package com.benqio.push.common.dao;

import com.benqio.push.common.model.PlatFormDevice;
import com.benqio.push.common.vo.platformdevice.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 平台设备Dao接口
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-17 14:37:00
 */
public interface PlatFormDeviceDao {

    /**
     * 分页查询平台设备记录列表
     */
    List<PlatFormDeviceListItem> query(PlatFormDeviceList param);

    /**
     * 根据主键查询平台设备记录详情
     */
    PlatFormDevice selectById(PlatFormDeviceId param);

    /**
     * 添加平台设备新纪录
     */
    PlatFormDevice insert(PlatFormDevice param);

    /**
     * 根据主键删除平台设备记录
     */
    int deleteById(PlatFormDeviceRemove param);

    /**
     * 更新平台设备记录
     */
    int update(PlatFormDevice param);

    /*依据组织结构和异常类型编码查询平台设备*/
    List<PlatFormDevice> getPlatFormDeviceByOrgCodeAndErrorType(@Param("orgCode") String orgCode, @Param("errorType") String errorType);

    /*统计推送资源总数*/
    @Select("select count(*) from tb_platformdevice")
    Integer getPlatFormDevice();

}




