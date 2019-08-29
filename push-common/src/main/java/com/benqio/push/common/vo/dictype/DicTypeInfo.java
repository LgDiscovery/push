package com.benqio.push.common.vo.dictype;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;

/**
 * 字典类型详细信息
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-6 11:42:44
 */
@Setter
@Getter
@ApiModel(value = "字典类型详细信息")
public class DicTypeInfo extends DicTypeId {

    /**
     * 字典类型编码
     */
    @ApiModelProperty(value = "字典类型编码")
    private String code;

    /**
     * 字典类型名称
     */
    @ApiModelProperty(value = "字典类型名称")
    @NotBlank
    private String name;

    /**
     * 字典类型状态:0.禁用、1.正常
     */
    @ApiModelProperty(value = "字典类型状态:0.禁用、1.正常")
    private Byte state;

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




