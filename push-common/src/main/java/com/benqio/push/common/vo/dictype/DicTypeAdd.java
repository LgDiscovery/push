package com.benqio.push.common.vo.dictype;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;

/**
 * 添加字典类型参数
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-6 11:42:44
 */
@Setter
@Getter
@ApiModel(value = "添加字典类型参数")
public class DicTypeAdd {


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







}




