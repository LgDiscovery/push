package com.benqio.push.common.vo.platformcatalog;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

/**
 * 平台地区详细信息
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-4 19:38:07
 */
@Setter
@Getter
@ApiModel(value = "平台地区详细信息")
public class PlatFormCatalogListItem extends PlatFormCatalogId implements Serializable {

    /**
     * 地区ID
     */
    @ApiModelProperty(value = "地区ID")
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
    private String description;

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




