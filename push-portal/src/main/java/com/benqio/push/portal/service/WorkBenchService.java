package com.benqio.push.portal.service;

import com.benqio.push.common.vo.workbench.WorkBenchCount;
import com.benqio.push.common.vo.workbench.WorkBenchCountParam;
import com.benqio.push.common.vo.workbench.WorkBenchResourceDemandParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 工作台 服务接口
 */
public interface WorkBenchService {

    /*推送资源情况总览查询*/
    List<WorkBenchCount> count();

    /*各单位推送资源情况总览查询*/
    List<WorkBenchCount> errorCount();

    /*各单位推送资源视频信号丢失查询*/
    List<WorkBenchCount> videoSign(WorkBenchCountParam param);

    /*各单位推送资源视频质量异常查询*/
    List<WorkBenchCount> videoQuality(WorkBenchCountParam param);

    /*各单位推送资源视频名称异常查询*/
    List<WorkBenchCount> videoName(WorkBenchCountParam param);

    /*点播热度排行查询*/
    List<WorkBenchCount> resourceDemand(WorkBenchResourceDemandParam param);

    /*推送实时状态消息到前端页面*/
     void pushToWebStatusMessage(HttpServletRequest request);

}
