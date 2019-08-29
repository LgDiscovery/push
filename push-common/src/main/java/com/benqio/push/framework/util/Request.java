package com.benqio.push.framework.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Request {
    
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    
    public static String fileName(HttpServletRequest request, String fileName) {
        final String agent = request.getHeader("USER-AGENT");
        try {
            if (StringUtils.hasText(agent)) {
                if (agent.contains("MSIE") || agent.contains("Trident") || agent.contains("Edge")) {
                    fileName = URLEncoder.encode(fileName, "UTF-8");
                } else if (agent.contains("Mozilla")) {
                    fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return fileName; // .replace("+", " ");
    }
}