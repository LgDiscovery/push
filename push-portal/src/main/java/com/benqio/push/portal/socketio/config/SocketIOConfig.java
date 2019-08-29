package com.benqio.push.portal.socketio.config;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@Log4j2
public class SocketIOConfig {

    @Resource
    private SocketIOProperties socketIOProperties;

    @Bean
    public SocketIOServer socketIOServer(){
        /**
         * 创建Socket，并设置监听端口
         */
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
//        设置主机名，默认为0.0.0.0
//        config.setHostname("0.0.0.0");
        //设置监听端口
        config.setPort(socketIOProperties.getPort());
        //协议升级超时时间(毫秒),默认10000.HTTP握手升级为ws协议超时时间
        config.setUpgradeTimeout(10000);
        //Ping消息间隔(毫秒),默认25000.客户端向服务端发送一条心跳消息
        config.setPingInterval(socketIOProperties.getPingInterval());
        //Ping消息超时时间(毫秒），默认为60000,这个时间间隔内没有收到心跳消息就会发送超时事件
        config.setPingTimeout(socketIOProperties.getPingTimeout());
        //握手协议参数使用JWT的Token认证方案
        config.setAuthorizationListener(data->{
            //可以使用如下代码获取用户密码信息
            String token = data.getSingleUrlParam("token");
            return true;
        });
        return new SocketIOServer(config);
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketIOServer){
        return new SpringAnnotationScanner(socketIOServer);
    }
}
