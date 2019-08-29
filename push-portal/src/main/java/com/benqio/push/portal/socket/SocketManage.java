package com.benqio.push.portal.socket;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Socket处理类
 */
@Service
public class SocketManage implements WebSocketHandler {



    private static final Map<String,List<WebSocketSession>> SESSIONS;

    private static final ExecutorService POOL;

    static {
        POOL = Executors.newCachedThreadPool();
        SESSIONS = new HashMap<String,List<WebSocketSession>>(32);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        String uk = (String) session.getAttributes().get("uk");
        String clientType = (String) session.getAttributes().get("clientType");
        String key = clientType+":"+uk;

        List<WebSocketSession> sessionList = SESSIONS.get(key);
        if(sessionList == null){
            sessionList = new ArrayList<>();
        }
        sessionList.add(session);
        SESSIONS.put(key,sessionList);

    }

    @Override
    public void handleMessage(WebSocketSession arg0, WebSocketMessage<?> message) {
        String payload = (String) message.getPayload();
        JSONObject jsonObject = JSONObject.parseObject(payload);
        if (Integer.valueOf(jsonObject.get("event").toString()) == 14) {
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable error) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        remove(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1) {
        remove(session);
    }
    private void remove(WebSocketSession session){
        SESSIONS.values().forEach(a->{
            a.remove(session);
        });
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    public Map<String,List<WebSocketSession>> getSessions(){
        return SESSIONS;
    }

    public boolean send(String clientType,String uk,TextMessage message){
        boolean success = true;
        String key = clientType+":"+uk;
        List<WebSocketSession> sessionList = SESSIONS.get(key);
        if(CollectionUtils.isNotEmpty(sessionList)){
            for(WebSocketSession session : sessionList){
                if(session.isOpen()){
                    POOL.execute(new Thread(()->{
                        try{
                            if(session.isOpen()){
                                session.sendMessage(message);
                            }
                        }catch (IOException e){

                        }
                    }));
                    success = true;
                }
            }
        }else{
            success = false;
        }
        return success;
    }

    public boolean sendToAll(TextMessage message){
        boolean success = true;
        Set<String> strings = SESSIONS.keySet();
        if(CollectionUtils.isNotEmpty(strings)){
            for(String str : strings){
                List<WebSocketSession> sessions = SESSIONS.get(str);
                if(CollectionUtils.isNotEmpty(sessions)){
                    for(WebSocketSession session : sessions){
                        if(session.isOpen()){
                            POOL.execute(new Thread(()->{
                                try{
                                    if(session.isOpen()){
                                        session.sendMessage(message);
                                    }
                                }catch (IOException e){
                                    e.printStackTrace();
                                }
                            }));
                            success = true;
                        }
                    }
                }else{
                    success = false;
                }
            }
        }else{
            success = false;
        }
        return success;
    }
}
