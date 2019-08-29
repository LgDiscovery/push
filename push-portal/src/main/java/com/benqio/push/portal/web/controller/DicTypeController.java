package com.benqio.push.portal.web.controller;

import com.benqio.push.common.model.DicType;
import com.benqio.push.common.vo.dictype.*;
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
import com.benqio.push.portal.service.DicTypeService;

import javax.annotation.Resource;

/**
 * 字典类型控制器
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-6 11:42:44
 */
@Api(value="字典类型控制器",tags={"字典类型控制器--DicTypeController"})
@Controller
@RequestMapping(value = "/dicType/")
public class DicTypeController {

    @Resource
    private DicTypeService dicTypeService;

    /**
    *字典类型列表查询请求
    *
    * @param param 查询参数
    * @return rest结果
    */
    //@Permission(value = ":dicType:list")
    @ApiOperation(value = "字典类型列表查询请求")
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "字典类型",action = BusinessType.LIST)
    public ResultPage<DicTypeListItem> list(@Validated @RequestBody DicTypeList param) {
       PageInfo<DicTypeListItem> data = dicTypeService.list(param);
       return new ResultPage<>(data);
    }

    /**
    *字典类型添加请求
    *
    * @param param 添加参数
    * @return rest结果
    */
    //@Permission(value = ":dicType:add")
    @ApiOperation(value = "字典类型添加请求")
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "字典类型",action = BusinessType.INSERT)
    public ResultData<DicTypeId> add(@Validated @RequestBody DicTypeAdd param) {
        DicType bean = dicTypeService.add(param);
        return new ResultData<>(new DicTypeId(bean.getId()));
    }

    /**
    *字典类型修改请求
    *
    * @param param 修改参数
    * @return rest结果
    */
    //@Permission(value = ":dicType:edit")
    @ApiOperation(value = "字典类型修改请求")
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "字典类型",action = BusinessType.OTHER)
    public Result edit(@Validated @RequestBody DicTypeEdit param) {
        dicTypeService.edit(param);
        return Result.SUCCESS;
    }

    /**
    *字典类型单个查询请求
    *
    * @param param 详细参数
    * @return rest结果
    */
    //@Permission(value = ":dicType:info")
    @ApiOperation(value = "字典类型单个查询请求")
    @RequestMapping(value = "info",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "字典类型",action = BusinessType.UPDATE)
    public ResultData<DicType> info(@Validated @RequestBody DicTypeId param) {
        DicType data = dicTypeService.info(param);
        return new ResultData<>(data);
    }

    /**
    *字典类型删除请求
    *
    * @param param 删除参数
    * @return rest结果
    */
    //@Permission(value = ":dicType:remove")
    @ApiOperation(value = "字典类型删除请求")
    @RequestMapping(value = "remove",method = RequestMethod.POST )
    @ResponseBody
    @OperLogAnnotation(title = "字典类型",action = BusinessType.DELETE)
    public Result remove(@Validated @RequestBody DicTypeRemove param) {
        dicTypeService.remove(param);
        return Result.SUCCESS;
    }

}




