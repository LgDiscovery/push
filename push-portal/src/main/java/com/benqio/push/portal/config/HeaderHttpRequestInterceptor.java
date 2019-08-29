package com.benqio.push.portal.config;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class HeaderHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    private Map<String,String> haderMap;

    public HeaderHttpRequestInterceptor(Map<String, String> haderMap) {
        this.haderMap = haderMap;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpRequestWrapper requestWrapper = new HttpRequestWrapper(request);
        if(!Objects.isNull(haderMap)){
            for(Map.Entry<String,String> entry : haderMap.entrySet()){
                requestWrapper.getHeaders().set(entry.getKey(),entry.getValue());
            }
        }
        return execution.execute(requestWrapper,body);
    }
}
