package com.benqio.push.portal.web.controller;

import com.benqio.push.common.model.Organization;
import com.benqio.push.common.vo.organization.*;
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
import com.benqio.push.portal.service.OrganizationService;

import javax.annotation.Resource;

/**
 * 组织机构控制器
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-19 19:02:49
 */
@Api(value="组织机构控制器",tags={"组织机构控制器--OrganizationController"})
@Controller
@RequestMapping(value = "/organization/")
public class OrganizationController {

    @Resource
    private OrganizationService organizationService;

    /**
    *组织机构列表查询请求
    *
    * @param param 查询参数
    * @return rest结果
    */
    //@Permission(value = ":organization:list")
    @ApiOperation(value = "组织机构列表查询请求")
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "组织机构",action = BusinessType.LIST)
    public ResultPage<OrganizationListItem> list(@Validated @RequestBody OrganizationList param) {
       PageInfo<OrganizationListItem> data = organizationService.list(param);
       return new ResultPage<>(data);
    }

    /**
    *组织机构添加请求
    *
    * @param param 添加参数
    * @return rest结果
    */
    //@Permission(value = ":organization:add")
    @ApiOperation(value = "组织机构添加请求")
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "组织机构",action = BusinessType.INSERT)
    public ResultData<OrganizationId> add(@Validated @RequestBody OrganizationAdd param) {
        Organization bean = organizationService.add(param);
        return new ResultData<>(new OrganizationId(bean.getId()));
    }

    /**
    *组织机构修改请求
    *
    * @param param 修改参数
    * @return rest结果
    */
    //@Permission(value = ":organization:edit")
    @ApiOperation(value = "组织机构修改请求")
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "组织机构",action = BusinessType.OTHER)
    public Result edit(@Validated @RequestBody OrganizationEdit param) {
        organizationService.edit(param);
        return Result.SUCCESS;
    }

    /**
    *组织机构单个查询请求
    *
    * @param param 详细参数
    * @return rest结果
    */
    //@Permission(value = ":organization:info")
    @ApiOperation(value = "组织机构单个查询请求")
    @RequestMapping(value = "info",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "组织机构",action = BusinessType.UPDATE)
    public ResultData<Organization> info(@Validated @RequestBody OrganizationId param) {
        Organization data = organizationService.info(param);
        return new ResultData<>(data);
    }

    /**
    *组织机构删除请求
    *
    * @param param 删除参数
    * @return rest结果
    */
    //@Permission(value = ":organization:remove")
    @ApiOperation(value = "组织机构删除请求")
    @RequestMapping(value = "remove",method = RequestMethod.POST )
    @ResponseBody
    @OperLogAnnotation(title = "组织机构",action = BusinessType.DELETE)
    public Result remove(@Validated @RequestBody OrganizationRemove param) {
        organizationService.remove(param);
        return Result.SUCCESS;
    }

}




