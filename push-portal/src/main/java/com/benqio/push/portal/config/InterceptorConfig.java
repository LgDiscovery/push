/*
package com.benqio.push.portal.config;

import com.benqio.push.sso.interceptor.SsoSessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    


    @Resource
    private SsoSessionInterceptor sessionInterceptor;



    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**").excludePathPatterns("/swagger/**","/swagger-ui.html","/webjars/**","/swagger-resources/**","/v2/**",
                "/api/**","/login","/logout","/sso/login","/sso/logout","/sso/dept/tree","/sso/ticket/verify","/autoLogin","/actuator/**");
        //registry.addInterceptor(sessionInterceptor).addPathPatterns().excludePathPatterns("/**","/swagger/**","/swagger-ui.html","/webjars/**","/swagger-resources/**","/v2/**",
        //        "/api/**","/login","/logout","/sso/login","/sso/logout","/sso/dept/tree","/sso/ticket/verify","/autoLogin","/actuator/**");

        super.addInterceptors(registry);
    }



}*/
