package com.benqio.push.portal.web.controller;

import com.benqio.push.common.annotation.OperLogAnnotation;
import com.benqio.push.common.constant.BusinessType;
import com.benqio.push.common.model.DicItem;
import com.benqio.push.common.vo.dicitem.*;
import com.benqio.push.framework.beans.Result;
import com.benqio.push.framework.beans.ResultData;
import com.benqio.push.framework.beans.ResultPage;
import com.benqio.push.portal.service.DicItemService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 字典项控制器
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-6 11:42:44
 */
@Api(value="字典项控制器",tags={"字典项控制器--DicItemController"})
@Controller
@RequestMapping(value = "/dicItem/")
public class DicItemController {

    @Resource
    private DicItemService dicItemService;

    /**
    *字典项列表查询请求
    *
    * @param param 查询参数
    * @return rest结果
    */
    //@Permission(value = ":dicItem:list")
    @ApiOperation(value = "字典项列表查询请求")
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "字典项",action = BusinessType.LIST)
    public ResultPage<DicItemListItem> list(@Validated @RequestBody DicItemList param) {
       PageInfo<DicItemListItem> data = dicItemService.list(param);
       return new ResultPage<>(data);
    }

    /**
    *字典项添加请求
    *
    * @param param 添加参数
    * @return rest结果
    */
    //@Permission(value = ":dicItem:add")
    @ApiOperation(value = "字典项添加请求")
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "字典项",action = BusinessType.INSERT)
    public ResultData<DicItemId> add(@Validated @RequestBody DicItemAdd param) {
        DicItem bean = dicItemService.add(param);
        return new ResultData<>(new DicItemId(bean.getId()));
    }

    /**
    *字典项修改请求
    *
    * @param param 修改参数
    * @return rest结果
    */
    //@Permission(value = ":dicItem:edit")
    @ApiOperation(value = "字典项修改请求")
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "字典项",action = BusinessType.OTHER)
    public Result edit(@Validated @RequestBody DicItemEdit param) {
        dicItemService.edit(param);
        return Result.SUCCESS;
    }

    /**
    *字典项单个查询请求
    *
    * @param param 详细参数
    * @return rest结果
    */
    //@Permission(value = ":dicItem:info")
    @ApiOperation(value = "字典项单个查询请求")
    @RequestMapping(value = "info",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "字典项",action = BusinessType.UPDATE)
    public ResultData<DicItem> info(@Validated @RequestBody DicItemId param) {
        DicItem data = dicItemService.info(param);
        return new ResultData<>(data);
    }

    /**
    *字典项删除请求
    *
    * @param param 删除参数
    * @return rest结果
    */
    //@Permission(value = ":dicItem:remove")
    @ApiOperation(value = "字典项删除请求")
    @RequestMapping(value = "remove",method = RequestMethod.POST )
    @ResponseBody
    @OperLogAnnotation(title = "字典项",action = BusinessType.DELETE)
    public Result remove(@Validated @RequestBody DicItemRemove param) {
        dicItemService.remove(param);
        return Result.SUCCESS;
    }

}




