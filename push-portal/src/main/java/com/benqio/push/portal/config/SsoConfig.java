package com.benqio.push.portal.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class SsoConfig {

    /** 用户中心请求路径 */
    @Value("${sso.server}")
    private String ServerUrl;

}
