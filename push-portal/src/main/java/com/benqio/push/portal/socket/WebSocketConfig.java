package com.benqio.push.portal.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @desp websocket配置
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private SocketManage socketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        registry.addHandler(socketHandler, "/webSocket")
                .addInterceptors(new WebSocketInterceptor())
                .setAllowedOrigins("*")
                .withSockJS();

//        registry.addHandler(socketHandler, "/webSocket")
//                .addInterceptors(new WebSocketInterceptor())
//                .setAllowedOrigins("*");


//        registry.addHandler(socketHandler, "/sockjs/webSocket")
//                .addInterceptors(new WebSocketInterceptor())
//                .withSockJS();
    }

}
