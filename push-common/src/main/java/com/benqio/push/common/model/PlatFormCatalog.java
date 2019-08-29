package com.benqio.push.common.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 平台地区 实体类
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-4 19:38:07
 */
@Setter
@Getter
@SuppressWarnings("serial")
public class PlatFormCatalog implements Serializable {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 地区ID
     */
    private String standardId;

    /**
     * 父地区ID
     */
    private String parentStandardId;

    /**
     * 名字
     */
    private String name;

    /**
     * 平台ID
     */
    private Integer platformId;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}




