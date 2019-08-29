package com.benqio.push.framework.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@SuppressWarnings("serial")
@ApiModel(value="字典对象")
public class Option implements Serializable {
    @ApiModelProperty(value = "数据库存值")
    private String value;
    @ApiModelProperty(value = "显示值")
    private String text;
    
}