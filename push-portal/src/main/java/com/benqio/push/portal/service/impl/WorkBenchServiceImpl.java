package com.benqio.push.portal.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.benqio.push.common.model.DicItem;
import com.benqio.push.common.model.Organization;
import com.benqio.push.common.model.PlatFormDevice;
import com.benqio.push.common.vo.workbench.WorkBenchCount;
import com.benqio.push.common.vo.workbench.WorkBenchCountParam;
import com.benqio.push.common.vo.workbench.WorkBenchResourceDemandParam;
import com.benqio.push.portal.Constant;
import com.benqio.push.portal.service.DicItemService;
import com.benqio.push.portal.service.OrganizationService;
import com.benqio.push.portal.service.PlatFormDeviceService;
import com.benqio.push.portal.service.WorkBenchService;
import com.benqio.push.portal.socket.SocketManage;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 工作台服务实现类
 */
@Service
public class WorkBenchServiceImpl implements WorkBenchService {


    @Resource
    private PlatFormDeviceService platFormDeviceService;

    @Resource
    private OrganizationService organizationService;

    @Resource
    private DicItemService dicItemService;

    @Resource
    private SocketManage socketManage;


    /*推送资源情况总览请求*/
    @Override
    public List<WorkBenchCount> count() {
        List<WorkBenchCount> countList = Lists.newArrayList();
        WorkBenchCount bean = new WorkBenchCount();
        bean.setName(Constant.RESOURCE_TOTAL);
        bean.setCount(platFormDeviceService.getPlatFormDevice());
        countList.add(bean);
        List<DicItem> dicItemList = dicItemService.getDicItemByTypeCode(Constant.ERROR_CODE);
        for (DicItem item : dicItemList) {
            WorkBenchCount count = new WorkBenchCount();
            count.setName(item.getName());
            List<PlatFormDevice> platFormDeviceList = platFormDeviceService.
                    getPlatFormDeviceByOrgCodeAndErrorType(null, item.getCode());
            Integer size = CollectionUtil.isEmpty(platFormDeviceList) ? 0 : platFormDeviceList.size();
            count.setCount(size);
            countList.add(count);
        }
        return countList;
    }

    /*各单位推送资源情况总览查询*/
    @Override
    public List<WorkBenchCount> errorCount() {
        List<WorkBenchCount> countList = Lists.newArrayList();
        List<Organization> allOrganization = organizationService.getAllOrganization();
        for (Organization organization : allOrganization) {
            List<PlatFormDevice> platFormDeviceLst = platFormDeviceService.
                    getPlatFormDeviceByOrgCodeAndErrorType(organization.getCode(), null);
            if (CollectionUtils.isNotEmpty(platFormDeviceLst)) {
                WorkBenchCount count = new WorkBenchCount();
                count.setName(organization.getName());
                count.setCount(platFormDeviceLst.size());
            }
        }
        return countList;
    }

    /*各单位推送资源视频信号丢失查询*/
    @Override
    public List<WorkBenchCount> videoSign(WorkBenchCountParam param) {
        List<WorkBenchCount> countList = Lists.newArrayList();
        List<Organization> allOrganization = organizationService.getAllOrganization();
        for (Organization organization : allOrganization) {
            List<PlatFormDevice> platFormDeviceList = platFormDeviceService.
                    getPlatFormDeviceByOrgCodeAndErrorType(organization.getCode(), Constant.VIDEO_SIGN);
            if (CollectionUtils.isNotEmpty(platFormDeviceList)) {
                WorkBenchCount count = new WorkBenchCount();
                count.setName(organization.getName());
                count.setCount(platFormDeviceList.size());
            }
        }
        return countList;
    }

    /*各单位推送资源视频质量异常查询*/
    @Override
    public List<WorkBenchCount> videoQuality(WorkBenchCountParam param) {
        List<WorkBenchCount> countList = Lists.newArrayList();
        List<Organization> allOrganization = organizationService.getAllOrganization();
        for (Organization organization : allOrganization) {
            List<PlatFormDevice> platFormDeviceList = platFormDeviceService.
                    getPlatFormDeviceByOrgCodeAndErrorType(organization.getCode(), Constant.VIDEO_QUALITY);
            if (CollectionUtils.isNotEmpty(platFormDeviceList)) {
                WorkBenchCount count = new WorkBenchCount();
                count.setName(organization.getName());
                count.setCount(platFormDeviceList.size());
            }
        }
        return countList;
    }

    /*各单位推送资源视频名称异常查询*/
    @Override
    public List<WorkBenchCount> videoName(WorkBenchCountParam param) {
        List<WorkBenchCount> countList = Lists.newArrayList();
        List<Organization> allOrganization = organizationService.getAllOrganization();
        for (Organization organization : allOrganization) {
            List<PlatFormDevice> platFormDeviceList = platFormDeviceService.
                    getPlatFormDeviceByOrgCodeAndErrorType(organization.getCode(), Constant.VIDEO_NAME);
            if (CollectionUtils.isNotEmpty(platFormDeviceList)) {
                WorkBenchCount count = new WorkBenchCount();
                count.setName(organization.getName());
                count.setCount(platFormDeviceList.size());
            }
        }
        return countList;
    }

    /*点播热度排行查询*/
    @Override
    public List<WorkBenchCount> resourceDemand(WorkBenchResourceDemandParam param) {

        return null;
    }

    /*推送实时状态消息到前端页面*/
    @Override
    public void pushToWebStatusMessage(HttpServletRequest request) {
        String clientType = request.getParameter("clientType");
        String uk = request.getParameter("uk");
        socketManage.send(clientType, uk, new TextMessage("你好 啊！"));
    }


}
