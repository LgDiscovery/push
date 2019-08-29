package com.benqio.push.common.vo.platformcatalog;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 移除平台地区参数
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-4 19:38:07
 */
@Setter
@Getter
@ApiModel(value = "移除平台地区参数")
public class PlatFormCatalogRemove extends PlatFormCatalogId {

}




