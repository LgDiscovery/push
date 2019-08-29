package com.benqio.push.portal.service.impl;

import com.benqio.push.common.model.PlatFormDevice;
import com.benqio.push.common.dao.PlatFormDeviceDao;
import com.benqio.push.common.vo.platformdevice.*;
import com.github.pagehelper.PageInfo;
import com.benqio.push.framework.beans.Result;
import com.benqio.push.framework.beans.ResultData;
import com.benqio.push.framework.beans.ResultPage;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.beans.BeanUtils;
import com.benqio.push.portal.service.PlatFormDeviceService;
import com.benqio.push.framework.Message;

import javax.annotation.Resource;
import java.util.List;

/**
 * 平台设备 服务接口实现类
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-17 14:37:00
 */
@Service
public class PlatFormDeviceServiceImpl implements PlatFormDeviceService {

    @Resource
    private PlatFormDeviceDao platFormDeviceDao;

    @Override
    public PageInfo<PlatFormDeviceListItem> list(PlatFormDeviceList param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        PageInfo<PlatFormDeviceListItem> list = new PageInfo<>(platFormDeviceDao.query(param));
        return list;
    }

    @Override
    public PlatFormDevice check(PlatFormDeviceId param) {
        PlatFormDevice bean = platFormDeviceDao.selectById(param);
        Assert.notNull(bean, Message.WARN_BEAN_DOES_NOT_EXIST);
        return bean;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PlatFormDevice add(PlatFormDeviceAdd param) {
        PlatFormDevice bean = new PlatFormDevice();
        BeanUtils.copyProperties(param, bean);
        //bean.setId(RandomUtil.simpleUUID());
        platFormDeviceDao.insert(bean);
        return bean;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void edit(PlatFormDeviceEdit param) {
        PlatFormDevice bean = this.check(new PlatFormDeviceId(param.getId()));
        BeanUtils.copyProperties(param, bean);
        platFormDeviceDao.update(bean);
    }

    @Override
    public PlatFormDevice info(PlatFormDeviceId param) {
        return platFormDeviceDao.selectById(param);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(PlatFormDeviceRemove param) {
        this.check(new PlatFormDeviceId(param.getId()));
        platFormDeviceDao.deleteById(param);
    }
    /*依据组织结构和异常类型编码查询平台设备*/
    @Override
    public List<PlatFormDevice> getPlatFormDeviceByOrgCodeAndErrorType(String orgCode, String errorType) {
        return platFormDeviceDao.getPlatFormDeviceByOrgCodeAndErrorType(orgCode,errorType);
    }

    /*统计推送资源总数*/
    @Override
    public Integer getPlatFormDevice() {
        return platFormDeviceDao.getPlatFormDevice();
    }

}




