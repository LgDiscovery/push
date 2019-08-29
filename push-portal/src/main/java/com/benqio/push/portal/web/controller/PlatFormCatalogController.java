package com.benqio.push.portal.web.controller;

import com.benqio.push.common.model.PlatFormCatalog;
import com.benqio.push.common.vo.platformcatalog.*;
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
import com.benqio.push.portal.service.PlatFormCatalogService;

import javax.annotation.Resource;

/**
 * 平台地区控制器
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-4 19:38:07
 */
@Api(value="平台地区控制器",tags={"平台地区控制器--PlatFormCatalogController"})
@Controller
@RequestMapping(value = "/platFormCatalog/")
public class PlatFormCatalogController {

    @Resource
    private PlatFormCatalogService platFormCatalogService;

    /**
    *平台地区列表查询请求
    *
    * @param param 查询参数
    * @return rest结果
    */
    //@Permission(value = ":platFormCatalog:list")
    @ApiOperation(value = "平台地区列表查询请求")
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "平台地区",action = BusinessType.LIST)
    public ResultPage<PlatFormCatalogListItem> list(@Validated @RequestBody PlatFormCatalogList param) {
       PageInfo<PlatFormCatalogListItem> data = platFormCatalogService.list(param);
       return new ResultPage<>(data);
    }

    /**
    *平台地区添加请求
    *
    * @param param 添加参数
    * @return rest结果
    */
    //@Permission(value = ":platFormCatalog:add")
    @ApiOperation(value = "平台地区添加请求")
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "平台地区",action = BusinessType.INSERT)
    public ResultData<PlatFormCatalogId> add(@Validated @RequestBody PlatFormCatalogAdd param) {
        PlatFormCatalog bean = platFormCatalogService.add(param);
        return new ResultData<>(new PlatFormCatalogId(bean.getId()));
    }

    /**
    *平台地区修改请求
    *
    * @param param 修改参数
    * @return rest结果
    */
    //@Permission(value = ":platFormCatalog:edit")
    @ApiOperation(value = "平台地区修改请求")
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "平台地区",action = BusinessType.OTHER)
    public Result edit(@Validated @RequestBody PlatFormCatalogEdit param) {
        platFormCatalogService.edit(param);
        return Result.SUCCESS;
    }

    /**
    *平台地区单个查询请求
    *
    * @param param 详细参数
    * @return rest结果
    */
    //@Permission(value = ":platFormCatalog:info")
    @ApiOperation(value = "平台地区单个查询请求")
    @RequestMapping(value = "info",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "平台地区",action = BusinessType.UPDATE)
    public ResultData<PlatFormCatalog> info(@Validated @RequestBody PlatFormCatalogId param) {
        PlatFormCatalog data = platFormCatalogService.info(param);
        return new ResultData<>(data);
    }

    /**
    *平台地区删除请求
    *
    * @param param 删除参数
    * @return rest结果
    */
    //@Permission(value = ":platFormCatalog:remove")
    @ApiOperation(value = "平台地区删除请求")
    @RequestMapping(value = "remove",method = RequestMethod.POST )
    @ResponseBody
    @OperLogAnnotation(title = "平台地区",action = BusinessType.DELETE)
    public Result remove(@Validated @RequestBody PlatFormCatalogRemove param) {
        platFormCatalogService.remove(param);
        return Result.SUCCESS;
    }

}




