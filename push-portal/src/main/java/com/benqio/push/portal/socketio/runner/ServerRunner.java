package com.benqio.push.portal.socketio.runner;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Log4j2
public class ServerRunner implements CommandLineRunner {
    private final SocketIOServer server;

    @Autowired
    public ServerRunner(SocketIOServer server){
        this.server = server;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("ServerRunner 开始启动");
        server.start();
    }
}
