package com.benqio.push.framework.beans;


import com.benqio.push.framework.Constant;
import com.benqio.push.framework.ErrorCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@SuppressWarnings("serial")
public class ResultData<T> extends Result implements Serializable{
    
    private T data;


    public ResultData() {
    }

    public ResultData(T data) {
        this(ErrorCode.SUCCESS, Constant.SUCCESS, data);
    }
    
    public ResultData(Result result, T data) {
        this(result.getCode(), result.getMessage(), data);
    }
    
    public ResultData(int code, String message, T data) {
        super(code, message);
        if (null == data) {
//            data = new JSONObject();
        }
        this.data = data;
    }
    
}