package com.benqio.push.common.vo.${tableClass.shortClassName?lower_case};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

/**
 * ${tableClass.introspectedTable.fullyQualifiedTable.remark}详细信息
 *
 * @author YangGuang
 * @version v1.0.0
 * @since ${.now}
 */
@Setter
@Getter
@ApiModel(value = "${tableClass.introspectedTable.fullyQualifiedTable.remark}详细信息")
public class ${tableClass.shortClassName}ListItem extends ${tableClass.shortClassName}Id implements Serializable {

<#if tableClass.baseFields??>
    <#list tableClass.baseFields as field>
    /**
     * ${field.remarks?replace('\r|\n','','r')}
     */
    @ApiModelProperty(value = "${field.remarks?replace('\r|\n','','r')}")
    private ${field.shortTypeName} ${field.fieldName};

    </#list>
</#if>


}




