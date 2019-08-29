package com.benqio.push.framework;

public interface ErrorCode {
    
    public static final int ERROR = -1;
    
    public static final int BUSINESS = -2;
    
    public static final int SUCCESS = 0;
    
    public static final int UPDATE = 99;
    
    public static final int LOGIN = -100;

    public static final int TOKEN_INVALID = 401;

    public static final int NO_PERMISSION = 403;

    public static final int USER_DISABLED = 10001;

    public static final int USER_OR_PASSWORD_INVALID = 10002;

    public static final int REDIRECT = 302;


    
    /** 系统错误 */
    public static final int SYSTEM = 20000;
    
    /** 登录超时 */
    public static final int LOGIN_TIMEOUT = 20001;
    
    /** 没有权限 */

    /**
     * 没有App-Code
     */
    public static final int NO_APP_CODE = 200003;
    
    /** 参数为空 */
    public static final int PARA_EMPTY = 30001;
}