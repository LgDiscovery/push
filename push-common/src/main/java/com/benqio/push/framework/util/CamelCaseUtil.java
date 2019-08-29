package com.benqio.push.framework.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

@Slf4j
public class CamelCaseUtil {
    
    private static final char SEPARATOR = '_';
    
    public static String toUnderlineName(String s) {
        Assert.hasLength(s, "string must not be empty");
        StringBuilder sb = new StringBuilder();
        boolean upperCase = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i > 0 && i < (s.length() - 1)) {
                boolean nextUpperCase = Character.isUpperCase(c);
                if (nextUpperCase) {
                    if (!upperCase || Character.isLowerCase(s.charAt(i + 1))) {
                        sb.append(SEPARATOR);
                    }
                }
                upperCase = nextUpperCase;
            }
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
    
    public static String lowerCamelCase(String s) {
        Assert.hasLength(s, "string must not be empty");
        // s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == SEPARATOR) {
                if (i > 0) {
                    upperCase = true;
                }
            } else {
                if (upperCase) {
                    upperCase = false;
                    c = Character.toUpperCase(c);
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public static String UpperCamelCase(String s) {
        Assert.hasLength(s, "string must not be empty");
        s = lowerCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
    
    public static void main(String[] args) {
        log.debug(CamelCaseUtil.toUnderlineName("ISOCertifiedStaff"));
        log.debug(CamelCaseUtil.toUnderlineName("CertifiedStaff"));
        log.debug(CamelCaseUtil.toUnderlineName("UserID"));
        log.debug(CamelCaseUtil.toUnderlineName("helloWorld"));
        
        log.debug(CamelCaseUtil.lowerCamelCase("iso_certified_staff"));
        log.debug(CamelCaseUtil.lowerCamelCase("certified_staff"));
        log.debug(CamelCaseUtil.lowerCamelCase("user_id"));
        
        log.debug(CamelCaseUtil.UpperCamelCase("hello_world"));
        log.debug(CamelCaseUtil.UpperCamelCase("_hello_world"));
        log.debug(CamelCaseUtil.lowerCamelCase("hello_world"));
        log.debug(CamelCaseUtil.lowerCamelCase("_hello_world"));
    }
}