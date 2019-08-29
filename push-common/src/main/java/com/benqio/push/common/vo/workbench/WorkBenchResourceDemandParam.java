package com.benqio.push.common.vo.workbench;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel(value = "点播热度排行查询参数")
public class WorkBenchResourceDemandParam {

    @ApiModelProperty(value = "时间类型 1.过去24小时 2.所有时间")
    private Byte timeType;

    @ApiModelProperty(value = "点播类型 1.点播次数 2.点播时长")
    private Byte demandType;
}
