package com.benqio.push.common.vo.workbench;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel(value = "推送资源异常查询参数")
public class WorkBenchCountParam {

    @ApiModelProperty(value = "异常类型编码 001001视频信号丢失 001002视频质量异常 001003视频名称异常")
    private String code;

}
