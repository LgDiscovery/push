package com.benqio.push.framework.util;

public interface Regexp {
    
    public static final String IP = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])(\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)){3}$";
    
    public static final String PORT = "^([1-9]|[1-9]\\d{3}|[1-6][0-5][0-5][0-3][0-5])$";
    
    public static final String PASSWORD = "^\\w{6,10}$";
    
    /** 6至16位任意字符且不含空格 */
    public static final String PASSWORD_CN = "^\\s*[^\\s\u4e00-\u9fa5]{6,16}\\s*$";
    
    public final static String EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
}