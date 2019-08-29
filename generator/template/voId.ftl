package com.benqio.push.common.vo.${tableClass.shortClassName?lower_case};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * ${tableClass.introspectedTable.fullyQualifiedTable.remark}主键Id
 *
 * @author YangGuang
 * @version v1.0.0
 * @since ${.now}
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "${tableClass.introspectedTable.fullyQualifiedTable.remark}主键Id")
public class ${tableClass.shortClassName}Id{

<#if tableClass.pkFields??>
    <#list tableClass.pkFields as field>
    /**
     * ${field.remarks?replace('\r|\n','','r')}
     */
    <#if field.shortTypeName == 'Long' || field.shortTypeName == 'Integer'>
    @NotNull
    <#elseif field.shortTypeName == 'String'>
    @NotBlank
    </#if>
    @ApiModelProperty(value = "${field.remarks}")
    private ${field.shortTypeName} ${field.fieldName};

    </#list>
</#if>


}




