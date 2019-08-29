package com.benqio.push.common.vo.dicitem;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典项详细信息
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-6 11:42:44
 */
@Setter
@Getter
@ApiModel(value = "字典项详细信息")
public class DicItemListItem extends DicItemId implements Serializable {

    /**
     * 字典项编码
     */
    @ApiModelProperty(value = "字典项编码")
    private String code;

    /**
     * 字典项名称
     */
    @ApiModelProperty(value = "字典项名称")
    private String name;

    /**
     * 字典类型编码
     */
    @ApiModelProperty(value = "字典类型编码")
    private String typeCode;

    /**
     * 设定值
     */
    @ApiModelProperty(value = "设定值")
    private String value;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 字典项状态:0.禁用、1.正常
     */
    @ApiModelProperty(value = "字典项状态:0.禁用、1.正常")
    private Byte state;

    /**
     * 标识:0删除，1未删除
     */
    @ApiModelProperty(value = "标识:0删除，1未删除")
    private Byte sign;

    /**
     * 图标
     */
    @ApiModelProperty(value = "图标")
    private String icon;

    /**
     * 倒计时状态:0.不启用 1.启用
     */
    @ApiModelProperty(value = "倒计时状态:0.不启用 1.启用")
    private Byte countState;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;



}




