package com.benqio.push.portal.socketio.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.benqio.push.portal.socketio.message.ClientType;
import com.benqio.push.portal.socketio.message.MessageType;
import com.benqio.push.portal.socketio.message.SocketMessage;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Component
@Log4j2
public class MessageEventHandler {
    private final SocketIOServer server;

    @Autowired
    public MessageEventHandler(SocketIOServer server) {
        this.server = server;
    }

    /**
     * 添加connect事件，当客户端发起连接时调用
     *
     * @param ioClient
     */
    @OnConnect
    public void onConnect(SocketIOClient ioClient) {
        if (ioClient != null) {
            String type = ioClient.getHandshakeData().getSingleUrlParam("type");
            String name = ioClient.getHandshakeData().getSingleUrlParam("name");
            String deviceId = ioClient.getHandshakeData().getSingleUrlParam("deviceId");
//            String userId = ioClient.getHandshakeData().getSingleUrlParam("userId");

            if (StringUtils.isNotBlank(type) && ClientType.TYPES.contains(type)) {
                String clientId = ioClient.getSessionId().toString();
                ioClient.set("clientId", clientId);
                ioClient.set("type", type);
                ioClient.set("name", name);
                ioClient.set("deviceId", deviceId);
//                ioClient.set("userId",userId);
                ioClient.joinRoom(type);

//                Client client = new Client();
//                client.setDeviceId(deviceId);
//                client.setSessionId(clientId);
//                client.setName(name);
//                client.setType(type);
//                client.setStatus(Constant.CLIENT_STATUS_ONLINE);
//                client.setPushStatus(Constant.CLIENT_PUSH_STATUS_NO);
//                clientService.addOrUpdate(client);
//                //向总控发送设备上线消息
                SocketMessage socketMessage = new SocketMessage();
                socketMessage.setType("online");
                JSONObject data = new JSONObject();
                data.put("clientId", clientId);
                data.put("type", type);
                data.put("name", name);
                data.put("deviceId", deviceId);
                socketMessage.setData(data);
                server.getRoomOperations(ClientType.MAIN_CONTROL_CLIENT).sendEvent("message", ioClient, socketMessage);
            } else if (StringUtils.isNotBlank(type) && ClientType.WEB_CLIENT.equals(type)) {
                // TODO: 2018-10-14  web客户端逻辑
            } else if (StringUtils.isNotBlank(type) && ClientType.ANNOUNCEMENT_CLIENT.equals(type)) {
                String clientId = ioClient.getSessionId().toString();
                ioClient.set("clientId", clientId);
                ioClient.set("type", type);
                ioClient.set("deviceId", deviceId);
                ioClient.joinRoom(type);
//                AnnouncementDeviceCache.put(deviceId,clientId);
                ioClient.joinRoom(type);
            }
        } else {
            log.error("客户端为空");
        }
    }

    /**
     * 添加onDisconnect事件，客户端断开连接时调用，刷新客户端信息
     *
     * @param ioClient
     */
    @OnDisconnect
    public void onDisconnect(SocketIOClient ioClient) {
        String type = ioClient.get("type");
        String deviceId = ioClient.get("deviceId");
        String clientId = ioClient.get("clientId");
//        String userId = ioClient.get("userId");
        String name = ioClient.get("name");

        if (ClientType.TYPES.contains(type)) {

            ioClient.leaveRoom(type);
            ioClient.disconnect();
//            clientService.updateStatus(deviceId,type,Constant.CLIENT_STATUS_OFFLINE);

            //向总控发送设备离线消息
            SocketMessage socketMessage = new SocketMessage();
            socketMessage.setType("offline");
            JSONObject data = new JSONObject();
            data.put("clientId", clientId);
            data.put("deviceId", deviceId);
            data.put("type", type);
            data.put("name", name);
            socketMessage.setData(data);
            server.getRoomOperations(ClientType.MAIN_CONTROL_CLIENT).sendEvent("message", ioClient, socketMessage);
        } else if (ClientType.WEB_CLIENT.equals(type)) {
            // TODO: 2018-10-14 web客户端逻辑
        } else if (ClientType.WEB_CLIENT.equals(type)) {
            ioClient.leaveRoom(type);
            ioClient.disconnect();
//            AnnouncementDeviceCache.remove(deviceId);
        }
    }

    /**
     * 消息接收入口
     *
     * @param ioClient
     * @param ackRequest
     * @param message
     */
    @OnEvent(value = "message")
    public void onEvent(SocketIOClient ioClient, AckRequest ackRequest, SocketMessage message) {
        log.info("接收message:{}", JSON.toJSONString(message));
        String type = ioClient.get("type");
        if (ackRequest.isAckRequested()) {

        }
        if (MessageType.DEVICE_CHANGE.equals(message.getType())) {
            if (ClientType.MEETING_CONTROL_CLIENT.equals(type) || ClientType.MAIN_CONTROL_CLIENT.equals(type)) {
                server.getRoomOperations(ClientType.MEETING_CONTROL_CLIENT).sendEvent("message", ioClient, message);
                server.getRoomOperations(ClientType.MAIN_CONTROL_CLIENT).sendEvent("message", ioClient, message);
            }
        }
    }

    public void push(SocketMessage message) {
        if (CollectionUtils.isNotEmpty(message.getTargetClientIds())) {
            for (String clientId : message.getTargetClientIds()) {
                UUID uuid = UUID.fromString(clientId);
                SocketIOClient client = server.getClient(uuid);
                client.sendEvent("message", message);
            }
        }
    }

    public void push(String clientId, SocketMessage message) {
        UUID uuid = UUID.fromString(clientId);
        SocketIOClient client = server.getClient(uuid);
        client.sendEvent("message", message);
    }

    public void sendOnlineStatusChange(String deviceId, String deviceName, String type) {
        SocketMessage socketMessage = new SocketMessage();
        socketMessage.setType(type);
        JSONObject data = new JSONObject();
        data.put("clientId", deviceId);
        data.put("deviceId", deviceId);
        data.put("type", "pusher");
        data.put("name", deviceName);
        socketMessage.setData(data);
        server.getRoomOperations(ClientType.MAIN_CONTROL_CLIENT).sendEvent("message", socketMessage);
    }

    public void sendNewAnnouncement(String deviceId, String clientId) {
        UUID uuid = UUID.fromString(clientId);
        SocketIOClient client = server.getClient(uuid);
        if (!Objects.isNull(client)) {
            SocketMessage socketMessage = new SocketMessage();
            socketMessage.setType("newAnnouncement");
            JSONObject data = new JSONObject();
            socketMessage.setData(data);
            client.sendEvent("message", socketMessage);
        }

    }

    public void sendDeviceChange(SocketMessage message) {
        server.getRoomOperations(ClientType.MEETING_CONTROL_CLIENT).sendEvent("message", message);
        server.getRoomOperations(ClientType.MAIN_CONTROL_CLIENT).sendEvent("message", message);
    }

    public Collection<SocketIOClient> getAllClient() {
        return server.getAllClients();
    }

}
