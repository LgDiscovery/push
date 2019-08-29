package com.benqio.push.common.vo.${tableClass.shortClassName?lower_case};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;

/**
 * 添加${tableClass.introspectedTable.fullyQualifiedTable.remark}参数
 *
 * @author YangGuang
 * @version v1.0.0
 * @since ${.now}
 */
@Setter
@Getter
@ApiModel(value = "添加${tableClass.introspectedTable.fullyQualifiedTable.remark}参数")
public class ${tableClass.shortClassName}Add {

<#if tableClass.baseFields??>
    <#list tableClass.baseFields as field>

    <#if field.fieldName == 'creator' || field.fieldName == 'createTime' || field.fieldName == 'updateTime' >
    <#else>
    /**
     * ${field.remarks?replace('\r|\n','','r')}
     */
    @ApiModelProperty(value = "${field.remarks?replace('\r|\n','','r')}")
    <#if field.nullable && field.stringColumn>
    @NotBlank
    </#if>
    <#if field.nullable && field.shortTypeName == 'Long'>
    @NotNull
    </#if>
    private ${field.shortTypeName} ${field.fieldName};
    </#if>

    </#list>
</#if>


}




