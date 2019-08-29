package com.benqio.push.framework.beans;

import com.alibaba.fastjson.JSON;
import com.benqio.push.framework.Constant;
import com.benqio.push.framework.ErrorCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 
 * @since 2016年3月7日 下午10:25:23
 * @version v1.0.0
 * @author jinyifeng5969@163.com
 */
@Setter
@Getter
@SuppressWarnings("serial")
@ApiModel
public class Result implements Serializable{
    
    public static final Result SUCCESS = new Result(Constant.SUCCESS);

    @ApiModelProperty(value = "错误码,0 请求成功 非零,请求失败  403 没有权限")
    private int code;

    @ApiModelProperty(value = "响应消息")
    private String message;
    
    public Result() {
    }
    
    public Result(String message) {
        this(ErrorCode.SUCCESS, message);
    }
    
    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("{\"code\":").append(code).append(",\"message\":\"").append(message).append("\"}");
//        return sb.toString();
        return JSON.toJSONString(this);
    }
}