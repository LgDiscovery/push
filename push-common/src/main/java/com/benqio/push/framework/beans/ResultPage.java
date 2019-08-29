package com.benqio.push.framework.beans;


import com.benqio.push.framework.ErrorCode;
import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@SuppressWarnings("serial")
public class ResultPage<T> extends Result implements Serializable {

    private PageInfo<T> data;

    public ResultPage(PageInfo<T> data) {
        this(ErrorCode.SUCCESS, "操作成功", data);
    }

    public ResultPage(int code, String message, PageInfo<T> data) {
        super(code, message);
        if (null == data) {
            data = new PageInfo();
        }
        this.data = data;
    }

}