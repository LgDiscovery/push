package com.benqio.push.common.vo.${tableClass.shortClassName?lower_case};

import com.benqio.push.framework.beans.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * ${tableClass.introspectedTable.fullyQualifiedTable.remark}列表查询参数
 *
 * @author YangGuang
 * @version v1.0.0
 * @since ${.now}
 */
@Setter
@Getter
@NoArgsConstructor
@ApiModel(value = "${tableClass.introspectedTable.fullyQualifiedTable.remark}列表查询参数")
public class ${tableClass.shortClassName}List extends PageParam {

<#if tableClass.allFields??>
 <#list tableClass.allFields as field>
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

 </#list>
</#if>
}




