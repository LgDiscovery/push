package com.benqio.push.portal.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class CmdbConfig {

    /** CMDB请求路径 */
    @Value("${cmdb.server}")
    private String ServerUrl;

    @Value("#{'${cmdb.modelCode}'.split(',')}")
    private List<String> modelCode;
}
