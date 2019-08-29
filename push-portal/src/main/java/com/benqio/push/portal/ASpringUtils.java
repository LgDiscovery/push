/**
 * Copyright (c) 2005-2009 springside.org.cn
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * $Id: SpringContextHolder.java 763 2009-12-27 18:36:21Z calvinxiu $
 */
package com.benqio.push.portal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Store Spring ApplicationContext
 * 
 * @author hanman
 */
@Service
@Lazy(false)
public class ASpringUtils implements ApplicationContextAware {
    
    private static ApplicationContext applicationContext;
    
    public void setApplicationContext(ApplicationContext applicationContext) {
        ASpringUtils.applicationContext = applicationContext;
    }
    
    /**
     * get applicationContext
     */
    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }
    
    /**
     * getbean
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }
    
    public static <T> T getBean(Class<T> clazz) {
        checkApplicationContext();
        return (T) applicationContext.getBean(clazz);
    }
    
    /**
     * public event
     */
    public static void publishEvent(ApplicationEvent event) {
        checkApplicationContext();
        applicationContext.publishEvent(event);
    }
    
    /**
     * transArgs: true get args from message first, then get the key
     * 
     * @param key
     * @param args
     * @param locale
     * @param transArgs
     * @return translated result message
     */
    public static String getMessage(String key, Object[] fields, Locale locale) {
        checkApplicationContext();
        try {
            return applicationContext.getMessage(key, fields, locale);
        } catch (NoSuchMessageException e) {
            return key;
        }
    }
    
    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("No SpringUtils, please define SpringUtils bean");
        }
    }
}
