package com.benqio.push.common.vo.platformcatalog;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;

/**
 * 编辑平台地区参数
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-4 19:38:07
 */
@Setter
@Getter
@ApiModel(value = "编辑平台地区参数")
public class PlatFormCatalogEdit extends PlatFormCatalogId {


    /**
     * 地区ID
     */
    @ApiModelProperty(value = "地区ID")
    @NotBlank
    private String standardId;


    /**
     * 父地区ID
     */
    @ApiModelProperty(value = "父地区ID")
    private String parentStandardId;


    /**
     * 名字
     */
    @ApiModelProperty(value = "名字")
    @NotBlank
    private String name;


    /**
     * 平台ID
     */
    @ApiModelProperty(value = "平台ID")
    private Integer platformId;


    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @NotBlank
    private String description;







}




