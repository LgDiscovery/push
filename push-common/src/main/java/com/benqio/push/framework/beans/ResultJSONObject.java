package com.benqio.push.framework.beans;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class ResultJSONObject extends Result implements Serializable {
    private JSONObject data;

    public ResultJSONObject() {
    }

    public ResultJSONObject(JSONObject data) {
        this(0, "操作成功", data);
    }

    public ResultJSONObject(Result result, JSONObject data) {
        this(result.getCode(), result.getMessage(), data);
    }

    public ResultJSONObject(int code, String message, JSONObject data) {
        super(code, message);
        if (null == data) {
            data = new JSONObject();
        }

        this.data = data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public JSONObject getData() {
        return this.data;
    }
}
