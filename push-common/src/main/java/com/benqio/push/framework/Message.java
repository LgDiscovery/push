package com.benqio.push.framework;

public interface Message {
    
    public static final String WARN_BEAN_DOES_NOT_EXIST = "该对象不存在或已经被删除！";
    
    public static final String WARN_CONNECTION_TIMED_OUT = "服务器连接超时！";
    
    public static final String WARN_DATA_VALIDATE_FAIL = "数据校验失败！";
    
    public static final String WARN_DB_CONNECTION_TIMED_OUT = "数据库连接超时！";
    
    public static final String WARN_DBSERVER_ERROR = "数据库服务异常！";
    
    public static final String WARN_DELETE_IN_USE_ROLE = "该角色正在被使用,不能被删除！";
    
    public static final String WARN_DELETE_ROLE = "该角色禁止被删除！";
    
    public static final String WARN_DUPLICATE_KEY_EXCEPTION = "存在重复主键，操作失败！";
    
    public static final String WARN_EXIST_ROLE_NAME = "该角色名称已存在！";
    
    public static final String WARN_LOGIN_FAIL = "登录失败！";
    
    public static final String WARN_NO_PRIVILEGE = "对不起您没有权限,请联系管理员！";
    
    public static final String WARN_PASSWORD_SAME = "两密码一样，请重新设置！";
    
    public static final String WARN_SET_ROLE_USER = "该用户角色禁止被修改！";
    
    public static final String WARN_UNEXPECTED_TYPE = "装配对象时数据类型不匹配！";
    
    public static final String WARN_VALIDATE_PARAM_FAIL = "有必填参数！";
    
}