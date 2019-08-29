package com.benqio.push.common.vo.dictype;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 移除字典类型参数
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-6 11:42:44
 */
@Setter
@Getter
@ApiModel(value = "移除字典类型参数")
public class DicTypeRemove extends DicTypeId {

}




