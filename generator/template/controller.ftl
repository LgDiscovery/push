package ${package};

import ${tableClass.fullClassName};
import com.benqio.push.common.vo.${tableClass.shortClassName?lower_case}.*;
import org.springframework.util.Assert;
import org.springframework.beans.BeanUtils;
import com.github.pagehelper.PageInfo;
import com.benqio.push.framework.beans.Result;
import com.benqio.push.framework.beans.ResultData;
import com.benqio.push.framework.beans.ResultPage;
import com.benqio.push.framework.annotation.Permission;
import com.benqio.push.common.annotation.OperLogAnnotation;
import com.benqio.push.common.constant.BusinessType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.benqio.push.portal.service.${tableClass.shortClassName}Service;

import javax.annotation.Resource;

/**
 * ${tableClass.introspectedTable.fullyQualifiedTable.remark}控制器
 *
 * @author YangGuang
 * @version v1.0.0
 * @since ${.now}
 */
@Api(value="${tableClass.introspectedTable.fullyQualifiedTable.remark}控制器",tags={"${tableClass.introspectedTable.fullyQualifiedTable.remark}控制器--${tableClass.shortClassName}Controller"})
@Controller
@RequestMapping(value = "/${tableClass.shortClassName?uncap_first}/")
public class ${tableClass.shortClassName}Controller {

    @Resource
    private ${tableClass.shortClassName}Service ${tableClass.shortClassName?uncap_first}Service;

    /**
    *${tableClass.introspectedTable.fullyQualifiedTable.remark}列表查询请求
    *
    * @param param 查询参数
    * @return rest结果
    */
    //@Permission(value = ":${tableClass.lowerCaseName}:list")
    @ApiOperation(value = "${tableClass.introspectedTable.fullyQualifiedTable.remark}列表查询请求")
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "${tableClass.introspectedTable.fullyQualifiedTable.remark}",action = BusinessType.LIST)
    public ResultPage<${tableClass.shortClassName}ListItem> list(@Validated @RequestBody ${tableClass.shortClassName}List param) {
       PageInfo<${tableClass.shortClassName}ListItem> data = ${tableClass.shortClassName?uncap_first}Service.list(param);
       return new ResultPage<>(data);
    }

    /**
    *${tableClass.introspectedTable.fullyQualifiedTable.remark}添加请求
    *
    * @param param 添加参数
    * @return rest结果
    */
    //@Permission(value = ":${tableClass.lowerCaseName}:add")
    @ApiOperation(value = "${tableClass.introspectedTable.fullyQualifiedTable.remark}添加请求")
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "${tableClass.introspectedTable.fullyQualifiedTable.remark}",action = BusinessType.INSERT)
    public ResultData<${tableClass.shortClassName}Id> add(@Validated @RequestBody ${tableClass.shortClassName}Add param) {
        ${tableClass.shortClassName} bean = ${tableClass.shortClassName?uncap_first}Service.add(param);
        return new ResultData<>(new ${tableClass.shortClassName}Id(bean.getId()));
    }

    /**
    *${tableClass.introspectedTable.fullyQualifiedTable.remark}修改请求
    *
    * @param param 修改参数
    * @return rest结果
    */
    //@Permission(value = ":${tableClass.lowerCaseName}:edit")
    @ApiOperation(value = "${tableClass.introspectedTable.fullyQualifiedTable.remark}修改请求")
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "${tableClass.introspectedTable.fullyQualifiedTable.remark}",action = BusinessType.OTHER)
    public Result edit(@Validated @RequestBody ${tableClass.shortClassName}Edit param) {
        ${tableClass.shortClassName?uncap_first}Service.edit(param);
        return Result.SUCCESS;
    }

    /**
    *${tableClass.introspectedTable.fullyQualifiedTable.remark}单个查询请求
    *
    * @param param 详细参数
    * @return rest结果
    */
    //@Permission(value = ":${tableClass.lowerCaseName}:info")
    @ApiOperation(value = "${tableClass.introspectedTable.fullyQualifiedTable.remark}单个查询请求")
    @RequestMapping(value = "info",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "${tableClass.introspectedTable.fullyQualifiedTable.remark}",action = BusinessType.UPDATE)
    public ResultData<${tableClass.shortClassName}> info(@Validated @RequestBody ${tableClass.shortClassName}Id param) {
        ${tableClass.shortClassName} data = ${tableClass.shortClassName?uncap_first}Service.info(param);
        return new ResultData<>(data);
    }

    /**
    *${tableClass.introspectedTable.fullyQualifiedTable.remark}删除请求
    *
    * @param param 删除参数
    * @return rest结果
    */
    //@Permission(value = ":${tableClass.lowerCaseName}:remove")
    @ApiOperation(value = "${tableClass.introspectedTable.fullyQualifiedTable.remark}删除请求")
    @RequestMapping(value = "remove",method = RequestMethod.POST )
    @ResponseBody
    @OperLogAnnotation(title = "${tableClass.introspectedTable.fullyQualifiedTable.remark}",action = BusinessType.DELETE)
    public Result remove(@Validated @RequestBody ${tableClass.shortClassName}Remove param) {
        ${tableClass.shortClassName?uncap_first}Service.remove(param);
        return Result.SUCCESS;
    }

}




