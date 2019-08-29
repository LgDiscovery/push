package com.benqio.push.common.vo.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 移除组织机构参数
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-19 19:02:49
 */
@Setter
@Getter
@ApiModel(value = "移除组织机构参数")
public class OrganizationRemove extends OrganizationId {

}




