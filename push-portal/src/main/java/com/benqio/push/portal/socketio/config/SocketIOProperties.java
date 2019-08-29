package com.benqio.push.portal.socketio.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "socketio")
public class SocketIOProperties {
    /**
     * socket端口
     */
    private Integer port;

    /**
     * Ping消息间隔(毫秒)
     */
    private Integer pingInterval;

    /**
     * Ping消息超时时间（毫秒）
     */
    private Integer pingTimeout;

    /**
     * APK文件访问URL前缀
     */
    private String apkUrlPrefix;
}
