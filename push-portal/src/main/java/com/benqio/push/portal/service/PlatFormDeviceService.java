package com.benqio.push.portal.service;

import com.benqio.push.common.model.PlatFormDevice;
import com.benqio.push.common.vo.platformdevice.*;
import com.github.pagehelper.PageInfo;
import com.benqio.push.framework.beans.Result;
import com.benqio.push.framework.beans.ResultData;
import com.benqio.push.framework.beans.ResultPage;

import java.util.List;

/**
 * 平台设备 服务接口
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-17 14:37:00
 */
public interface PlatFormDeviceService {

    /**
     *平台设备列表分页查询
     */
    PageInfo<PlatFormDeviceListItem> list(PlatFormDeviceList param);

    /**
     * 检查平台设备对象是否存在
     */
    PlatFormDevice check(PlatFormDeviceId param);

    /**
     * 根据主键查询平台设备详情
     */
    PlatFormDevice info(PlatFormDeviceId param);

    /**
     * 新增平台设备
     */
    PlatFormDevice add(PlatFormDeviceAdd param);

    /**
     * 编辑平台设备
     */
    void edit(PlatFormDeviceEdit param);

    /**
     * 移除平台设备
     */
    void remove(PlatFormDeviceRemove param);

    /**
     * 依据组织结构和异常类型编码查询平台设备
     */
    List<PlatFormDevice> getPlatFormDeviceByOrgCodeAndErrorType(String orgCode, String errorType);

    /**
     * 统计推送资源总数
     */
    Integer getPlatFormDevice();

}




