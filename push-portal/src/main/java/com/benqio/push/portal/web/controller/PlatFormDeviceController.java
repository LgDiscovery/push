package com.benqio.push.portal.web.controller;

import com.benqio.push.common.model.PlatFormDevice;
import com.benqio.push.common.vo.platformdevice.*;
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
import com.benqio.push.portal.service.PlatFormDeviceService;

import javax.annotation.Resource;

/**
 * 平台设备控制器
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-18 15:11:35
 */
@Api(value="平台设备控制器",tags={"平台设备控制器--PlatFormDeviceController"})
@Controller
@RequestMapping(value = "/platFormDevice/")
public class PlatFormDeviceController {

    @Resource
    private PlatFormDeviceService platFormDeviceService;

    /**
    *平台设备列表查询请求
    *
    * @param param 查询参数
    * @return rest结果
    */
    //@Permission(value = ":platformdevice:list")
    @ApiOperation(value = "平台设备列表查询请求")
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "平台设备",action = BusinessType.LIST)
    public ResultPage<PlatFormDeviceListItem> list(@Validated @RequestBody PlatFormDeviceList param) {
       PageInfo<PlatFormDeviceListItem> data = platFormDeviceService.list(param);
       return new ResultPage<>(data);
    }

    /**
    *平台设备添加请求
    *
    * @param param 添加参数
    * @return rest结果
    */
    //@Permission(value = ":platformdevice:add")
    @ApiOperation(value = "平台设备添加请求")
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "平台设备",action = BusinessType.INSERT)
    public ResultData<PlatFormDeviceId> add(@Validated @RequestBody PlatFormDeviceAdd param) {
        PlatFormDevice bean = platFormDeviceService.add(param);
        return new ResultData<>(new PlatFormDeviceId(bean.getId()));
    }

    /**
    *平台设备修改请求
    *
    * @param param 修改参数
    * @return rest结果
    */
    //@Permission(value = ":platformdevice:edit")
    @ApiOperation(value = "平台设备修改请求")
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "平台设备",action = BusinessType.OTHER)
    public Result edit(@Validated @RequestBody PlatFormDeviceEdit param) {
        platFormDeviceService.edit(param);
        return Result.SUCCESS;
    }

    /**
    *平台设备单个查询请求
    *
    * @param param 详细参数
    * @return rest结果
    */
    //@Permission(value = ":platformdevice:info")
    @ApiOperation(value = "平台设备单个查询请求")
    @RequestMapping(value = "info",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "平台设备",action = BusinessType.UPDATE)
    public ResultData<PlatFormDevice> info(@Validated @RequestBody PlatFormDeviceId param) {
        PlatFormDevice data = platFormDeviceService.info(param);
        return new ResultData<>(data);
    }

    /**
    *平台设备删除请求
    *
    * @param param 删除参数
    * @return rest结果
    */
    //@Permission(value = ":platformdevice:remove")
    @ApiOperation(value = "平台设备删除请求")
    @RequestMapping(value = "remove",method = RequestMethod.POST )
    @ResponseBody
    @OperLogAnnotation(title = "平台设备",action = BusinessType.DELETE)
    public Result remove(@Validated @RequestBody PlatFormDeviceRemove param) {
        platFormDeviceService.remove(param);
        return Result.SUCCESS;
    }

}




