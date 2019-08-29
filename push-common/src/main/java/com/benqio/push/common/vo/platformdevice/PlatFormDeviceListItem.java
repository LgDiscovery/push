package com.benqio.push.common.vo.platformdevice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

/**
 * 平台设备详细信息
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-18 15:11:35
 */
@Setter
@Getter
@ApiModel(value = "平台设备详细信息")
public class PlatFormDeviceListItem extends PlatFormDeviceId implements Serializable {

    /**
     * 国标标准
     */
    @ApiModelProperty(value = "国标标准")
    private String standardId;

    /**
     * 地区ID
     */
    @ApiModelProperty(value = "地区ID")
    private String catalogStandardId;

    /**
     * 组织机构编码
     */
    @ApiModelProperty(value = "组织机构编码")
    private String orgCode;

    /**
     * 名字
     */
    @ApiModelProperty(value = "名字")
    private String name;

    /**
     * 平台ID
     */
    @ApiModelProperty(value = "平台ID")
    private Integer platformId;

    /**
     * 设备ID
     */
    @ApiModelProperty(value = "设备ID")
    private String deviceId;

    /**
     * 通道号
     */
    @ApiModelProperty(value = "通道号")
    private Integer channelNo;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 异常类型编码(可以是多个,用逗号分割)
     */
    @ApiModelProperty(value = "异常类型编码(可以是多个,用逗号分割)")
    private String errorType;

    /**
     * 累计点播次数
     */
    @ApiModelProperty(value = "累计点播次数")
    private Integer demandCount;

    /**
     * 累计点播时长
     */
    @ApiModelProperty(value = "累计点播时长")
    private Integer demandTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;



}




