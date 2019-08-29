package com.benqio.push.common.vo.platformcatalog;

import com.benqio.push.framework.beans.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 平台地区列表查询参数
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-4 19:38:07
 */
@Setter
@Getter
@NoArgsConstructor
@ApiModel(value = "平台地区列表查询参数")
public class PlatFormCatalogList extends PageParam {

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private String id;

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




