package com.benqio.push.common.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 组织机构 实体类
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-19 19:02:49
 */
@Setter
@Getter
@SuppressWarnings("serial")
public class Organization implements Serializable {

    /**
     * ID编号
     */
    private Integer id;

    /**
     * 组织机构编号
     */
    private String code;

    /**
     * 组织机构名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态：0未启用，1启用
     */
    private Byte state;

    /**
     * 监狱类型：0不是 1是
     */
    private Byte type;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 更新时间
     */
    private Date update_time;

}




