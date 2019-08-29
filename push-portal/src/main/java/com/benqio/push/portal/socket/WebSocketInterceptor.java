package com.benqio.push.portal.socket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * websocket拦截器
 */
public class WebSocketInterceptor implements HandshakeInterceptor {

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler,
                               Exception exception) {
    }


    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler,
                                   Map<String, Object> attributes) throws Exception {
        if (request instanceof ServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            String clientType = servletRequest.getServletRequest().getParameter("clientType");
            String uk = servletRequest.getServletRequest().getParameter("uk");
            if(clientType == null || uk == null){
                return false;
            }
            attributes.put("clientType",clientType);
            attributes.put("uk",uk);
            return true;
        }
        return true;
    }

}
