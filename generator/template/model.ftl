package com.benqio.push.common.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * ${tableClass.introspectedTable.fullyQualifiedTable.remark} 实体类
 *
 * @author YangGuang
 * @version v1.0.0
 * @since ${.now}
 */
@Setter
@Getter
@SuppressWarnings("serial")
public class ${tableClass.shortClassName} implements Serializable {

<#if tableClass.pkFields??>
    <#list tableClass.pkFields as field>
    /**
     * ${field.remarks?replace('\r|\n','','r')}
     */
    private ${field.shortTypeName} ${field.fieldName};

    </#list>
</#if>
<#if tableClass.baseFields??>
    <#list tableClass.baseFields as field>
    /**
     * ${field.remarks?replace('\r|\n','','r')}
     */
    private ${field.shortTypeName} ${field.fieldName};

    </#list>
</#if>
}




