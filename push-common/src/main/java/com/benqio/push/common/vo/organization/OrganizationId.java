package com.benqio.push.common.vo.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 组织机构主键Id
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-19 19:02:49
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "组织机构主键Id")
public class OrganizationId{

    /**
     * ID编号
     */
    @NotNull
    @ApiModelProperty(value = "ID编号")
    private Integer id;



}




