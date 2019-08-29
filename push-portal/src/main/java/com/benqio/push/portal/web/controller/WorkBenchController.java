package com.benqio.push.portal.web.controller;

import com.benqio.framework.beans.ResultData;
import com.benqio.push.common.annotation.OperLogAnnotation;
import com.benqio.push.common.constant.BusinessType;
import com.benqio.push.common.vo.workbench.WorkBenchCount;
import com.benqio.push.common.vo.workbench.WorkBenchCountParam;
import com.benqio.push.common.vo.workbench.WorkBenchResourceDemandParam;
import com.benqio.push.framework.annotation.Permission;
import com.benqio.push.framework.beans.Result;
import com.benqio.push.portal.service.WorkBenchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 工作台控制器
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-4 19:38:07
 */
@Api(value="工作台控制器",tags={"工作台控制器--WorkBenchController"})
@Controller
@RequestMapping(value = "/workBench/")
public class WorkBenchController {

    @Resource
    private WorkBenchService workBenchService;


    /**
     *推送资源情况总览请求
     * @return rest结果
     */
    //@Permission(value = ":workBench:count")
    @ApiOperation(value = "推送资源情况总览请求")
    @RequestMapping(value = "count",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "工作台",action = BusinessType.LIST)
    public ResultData<List<WorkBenchCount>> count() {
        return new ResultData<>(workBenchService.count());
    }

    /**
     *各单位推送资源情况总览请求
     * @return rest结果
     */
    //@Permission(value = ":workBench:errorCount")
    @ApiOperation(value = "各单位推送资源情况总览请求")
    @RequestMapping(value = "errorCount",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "工作台",action = BusinessType.LIST)
    public ResultData<List<WorkBenchCount>> errorCount() {
        return new ResultData<>(workBenchService.errorCount());
    }

    /**
     *各单位推送资源视频信号丢失请求
     * @return rest结果
     */
    //@Permission(value = ":workBench:videoSign")
    @ApiOperation(value = "各单位推送资源视频信号丢失请求")
    @RequestMapping(value = "videoSign",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "工作台",action = BusinessType.LIST)
    public ResultData<List<WorkBenchCount>> videoSign(@Validated @RequestBody WorkBenchCountParam param) {
        return new ResultData<>(workBenchService.videoSign(param));
    }

    /**
     *各单位推送资源视频质量异常请求
     * @return rest结果
     */
    //@Permission(value = ":workBench:videoQuality")
    @ApiOperation(value = "各单位推送资源视频质量异常请求")
    @RequestMapping(value = "videoQuality",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "工作台",action = BusinessType.LIST)
    public ResultData<List<WorkBenchCount>> videoQuality(@Validated @RequestBody WorkBenchCountParam param) {
        return new ResultData<>(workBenchService.videoQuality(param));
    }

    /**
     *各单位推送资源视频名称异常请求
     * @return rest结果
     */
    //@Permission(value = ":workBench:videoName")
    @ApiOperation(value = "各单位推送资源视频名称异常请求")
    @RequestMapping(value = "videoName",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "工作台",action = BusinessType.LIST)
    public ResultData<List<WorkBenchCount>> videoName(@Validated @RequestBody WorkBenchCountParam param) {
        return new ResultData<>(workBenchService.videoName(param));
    }

    /**
     *点播热度排行请求
     * @return rest结果
     */
    //@Permission(value = ":workBench:resourceDemand")
    @ApiOperation(value = "点播热度排行请求")
    @RequestMapping(value = "resourceDemand",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "工作台",action = BusinessType.LIST)
    public ResultData<List<WorkBenchCount>> resourceDemand(@Validated @RequestBody WorkBenchResourceDemandParam param) {
        return new ResultData<>(workBenchService.resourceDemand(param));
    }

    /**
     * WebSocket实时状态消息请求
     * @param request
     * @return
     */
    @Permission(value = ":workBench:statusMessage")
    @ApiOperation(value = "WebSocket实时状态消息请求")
    @RequestMapping(value = "statusMessage",method = RequestMethod.POST)
    @ResponseBody
    @OperLogAnnotation(title = "工作台",action = BusinessType.OTHER)
    public Result statusMessage(HttpServletRequest request){
        workBenchService.pushToWebStatusMessage(request);
        return Result.SUCCESS;
    }
}
