package com.benqio.push.framework;

public interface Constant {
    
    public static final String $MENU = "menu";
    
    public static final String $PASSWORD = "PASSWORD";
    
    public static final String $PRIVILIGE = "privilige";
    
    public static final String $ROLE = "ROLE";
    
    public static final String $SESSIONID = "SESSIONID";
    
    public static final String $USER = "USER";
    
    public static final String $USERID = "USERID";
    
    public static final String $USERNAME = "USERNAME";
    
    public static final String CAPTCHA = "CAPTCHA";
    
    public static final String COLON = ":";
    
    public static final String DATE_TIME = "yyyy-MM-dd HH:mm";
    
    public static final String ERROR = "ERROR";
    
    public static final String ERRORS = "ERRORS";
    
    public static final String HTTP = "http://";
    
    public static final String HTTPS = "https://";
    
    public static final String JSON = "application/json;charset=utf-8";
    
    public static final String EXCEL_CONTENTTYPE = "application/vnd.ms-excel;charset=utf-8";
    
    public static final String MODEL = "bean";
    
    // 6至16位任意字符且不含空格
    public static final String REGEX_PASSWORD = "^\\s*[^\\s\u4e00-\u9fa5]{6,16}\\s*$";
    
    public static final String SUCCESS = "SUCCESS";
    
    public static final String URL = "url";
    
    public static final String PAGEINFO = "pageInfo";

    public static final Byte CLIENT_TYPE_FRONT = 1;
    public static final Byte CLIENT_TYPE_CLIENT = 2;

    public static final Boolean DELETED_NO = false;
    public static final Boolean DELETED_YES = true;

    public static final String CATEGORY_MODEL = "model";
    public static final String CATEGORY_TEMPLATE = "template";

    public static final Long GROUP_ROOT_ID = 0L;

    public static final Long GROUP_DEFAULT_PARENT_ID = 0L;

    public static final byte VISIBLE_NO = 0;
    public static final byte VISIBLE_YES = 1;


    public static final Boolean BUILTIN_NO = false;
    public static final Boolean BUILTIN_YES = true;

    public static final String RESTRICTION_ONE_ONE = "ONE_ONE";
    public static final String RESTRICTION_ONE_MANY = "ONE_MANY";
    public static final String RESTRICTION_MANY_ONE = "MANY_ONE";
    public static final String RESTRICTION_MANY_MANY = "MANY_MANY";

    public static final Long ORG_DEFAULT = 0L;


    /** 会议状态：0 未进行，1 已进行，2 已结束 */
    public static final Byte STATE_0 = 0, STATE_1 = 1, STATE_2 = 2;

    /** 预约状态 0预约中  1 已取消  2 已批准 3 已拒绝 */
    public static final Byte RESERVATION_STATE_0 = 0, RESERVATION_STATE_1 = 1, RESERVATION_STATE_2 = 2,RESERVATION_STATE_3 = 3;

    /** 锁定状态 0 未锁定 1锁定 2 加密 */
    public static final Byte LOCK_STATE_0 = 0, LOCK_STATE_1 = 1, LOCK_STATE_2 = 2;

    /** 状态 0 不在使用 1 在使用 */
    public static final Byte STATUS_0 = 0, STATUS_1 = 1;


}