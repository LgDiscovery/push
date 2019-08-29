package com.benqio.push.common.vo.platformcatalog;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 平台地区主键Id
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-4 19:38:07
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "平台地区主键Id")
public class PlatFormCatalogId{

    /**
     * 主键ID
     */
    @NotBlank
    @ApiModelProperty(value = "主键ID")
    private String id;



}




