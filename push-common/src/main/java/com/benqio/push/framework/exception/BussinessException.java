package com.benqio.push.framework.exception;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
public class BussinessException extends RuntimeException {
    
    private Object[] args;
    
    private BussinessException[] errors;
    
    private int errorCode;
    
    public BussinessException(int errorCode) {
        this(errorCode, "");
        this.errorCode = errorCode;
    }
    
    public BussinessException(int errorCode, Object... args) {
        this("code." + errorCode, args);
    }
    
    public BussinessException(String message) {
        super(message);
    }
    
    public BussinessException(String message, Object... args) {
        super(message);
        this.args = args;
    }
    
    public BussinessException(String message, BussinessException... errors) {
        this(message, "");
        this.errors = errors;
    }
    
    
}