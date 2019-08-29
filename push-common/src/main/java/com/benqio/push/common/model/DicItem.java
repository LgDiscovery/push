package com.benqio.push.common.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典项 实体类
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-6 11:42:44
 */
@Setter
@Getter
@SuppressWarnings("serial")
public class DicItem implements Serializable {

    /**
     * ID编号
     */
    private Integer id;

    /**
     * 字典项编码
     */
    private String code;

    /**
     * 字典项名称
     */
    private String name;

    /**
     * 字典类型编码
     */
    private String typeCode;

    /**
     * 设定值
     */
    private String value;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 字典项状态:0.禁用、1.正常
     */
    private Byte state;

    /**
     * 标识:0删除，1未删除
     */
    private Byte sign;

    /**
     * 图标
     */
    private String icon;

    /**
     * 倒计时状态:0.不启用 1.启用
     */
    private Byte countState;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

}




