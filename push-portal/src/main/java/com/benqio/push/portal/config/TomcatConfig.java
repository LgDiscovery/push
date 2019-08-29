package com.benqio.push.portal.config;

import lombok.extern.log4j.Log4j2;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author tongby
 */
//@Configuration
public class TomcatConfig {

//    @Value("${tomcat.ssl.port:8443}")
////    private int tomcatSSLPort;
////
////    @Value("${tomcat.ssl.key-store:}")
////    private String tomcatSSLKeyStore;
////
////    @Value("${tomcat.ssl.key-store-password:}")
////    private String tomcatSSLKeyStorePassword;
////
////    @Value("${tomcat.ssl.keyStoreType:PKCS12}")
////    private String tomcatSSLKeyStoreType;
////
////    @Value("${tomcat.ssl.keyAlias:tomcat}")
////    private String tomcatSSLKeyAlias;
////
////    @Value("${tomcat.ssl.enable:false}")
////    private Boolean tomcatSSLEnable;
////
////
////    @Bean
////    public GracefulShutdown gracefulShutdown(){
////        return new GracefulShutdown();
////    }
////
////    @Bean
////    public ServletWebServerFactory servletContainer(){
////        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
////        if(tomcatSSLEnable){
////            tomcat.addAdditionalTomcatConnectors(createSslConnector());
////        }
////
////        tomcat.addConnectorCustomizers(gracefulShutdown());
////        return tomcat;
////    }
////
////
////    /**
////     * 创建https connector
////     * @return
////     */
////    private Connector createSslConnector() {
////        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
////        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
////        try {
////            File keystore = ResourceUtils.getFile(tomcatSSLKeyStore);
////
////
////            connector.setScheme("https");
////            connector.setSecure(true);
////            connector.setPort(tomcatSSLPort);
////            connector.setAttribute("clientAuth",false);
////
////            protocol.setSSLEnabled(true);
////            protocol.setKeystoreFile(keystore.getAbsolutePath());
////            protocol.setKeystoreType(tomcatSSLKeyStoreType);
////            protocol.setKeystorePass(tomcatSSLKeyStorePassword);
////            protocol.setKeyPass(tomcatSSLKeyStorePassword);
//////            protocol.setTruststoreFile(keystore.getAbsolutePath());
//////            protocol.setTruststorePass(tomcatSSLKeyStorePassword);
////            protocol.setKeyAlias(tomcatSSLKeyAlias);
////            return connector;
////        }
////        catch (Exception ex) {
////            throw new IllegalStateException("can't access keystore: [" + "keystore"
////                    + "] or truststore: [" + "keystore" + "]", ex);
////        }
////    }
////
////    /**
////     * Spring Boot2.x Tomcat容器优雅停机
////     */
////    @Log4j2
////    private static class GracefulShutdown implements TomcatConnectorCustomizer,ApplicationListener<ContextClosedEvent>{
////        private volatile  Connector connector;
////        private final int waitTime = 120;
////
////
////        @Override
////        public void customize(Connector connector) {
////            this.connector = connector;
////        }
////
////        @Override
////        public void onApplicationEvent(ContextClosedEvent event) {
////            this.connector.pause();
////            Executor executor = this.connector.getProtocolHandler().getExecutor();
////            if( executor instanceof ThreadPoolExecutor){
////                try{
////                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
////                    log.info("shutdown start");
////                    threadPoolExecutor.shutdown();
////                    log.info("shutdown end");
////                    if(!threadPoolExecutor.awaitTermination(waitTime,TimeUnit.SECONDS)){
////                        log.info("Tomcat进程在" + waitTime+"秒内无法结束，尝试强制结束");
////                    }
////                    log.info("shutdown success");
////
////                }catch (InterruptedException ex){
////                    Thread.currentThread().interrupt();
////                }
////            }
////        }
////    }
}
