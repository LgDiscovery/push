package com.benqio.push.common.vo.${tableClass.shortClassName?lower_case};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 移除${tableClass.introspectedTable.fullyQualifiedTable.remark}参数
 *
 * @author YangGuang
 * @version v1.0.0
 * @since ${.now}
 */
@Setter
@Getter
@ApiModel(value = "移除${tableClass.introspectedTable.fullyQualifiedTable.remark}参数")
public class ${tableClass.shortClassName}Remove extends ${tableClass.shortClassName}Id {

}




