package com.benqio.push.common.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 平台设备 实体类
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-18 15:11:35
 */
@Setter
@Getter
@SuppressWarnings("serial")
public class PlatFormDevice implements Serializable {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 国标标准
     */
    private String standardId;

    /**
     * 地区ID
     */
    private String catalogStandardId;

    /**
     * 组织机构编码
     */
    private String orgCode;

    /**
     * 名字
     */
    private String name;

    /**
     * 平台ID
     */
    private Integer platformId;

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 通道号
     */
    private Integer channelNo;

    /**
     * 描述
     */
    private String description;

    /**
     * 异常类型编码(可以是多个,用逗号分割)
     */
    private String errorType;

    /**
     * 累计点播次数
     */
    private Integer demandCount;

    /**
     * 累计点播时长
     */
    private Integer demandTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}




