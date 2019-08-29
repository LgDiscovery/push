package com.benqio.push.portal.service.impl;

import com.benqio.push.common.model.PlatFormCatalog;
import com.benqio.push.common.dao.PlatFormCatalogDao;
import com.benqio.push.common.vo.platformcatalog.*;
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
import com.benqio.push.portal.service.PlatFormCatalogService;
import com.benqio.push.framework.Message;

import javax.annotation.Resource;

/**
 * 平台地区 服务接口实现类
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-4 19:38:07
 */
@Service
public class PlatFormCatalogServiceImpl implements PlatFormCatalogService {

    @Resource
    private PlatFormCatalogDao platFormCatalogDao;

    @Override
    public PageInfo<PlatFormCatalogListItem> list(PlatFormCatalogList param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        PageInfo<PlatFormCatalogListItem> list = new PageInfo<>(platFormCatalogDao.query(param));
        return list;
    }

    @Override
    public PlatFormCatalog check(PlatFormCatalogId param) {
        PlatFormCatalog bean = platFormCatalogDao.selectById(param);
        Assert.notNull(bean, Message.WARN_BEAN_DOES_NOT_EXIST);
        return bean;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PlatFormCatalog add(PlatFormCatalogAdd param) {
        PlatFormCatalog bean = new PlatFormCatalog();
        BeanUtils.copyProperties(param, bean);
        //bean.setId(RandomUtil.simpleUUID());
        platFormCatalogDao.insert(bean);
        return bean;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void edit(PlatFormCatalogEdit param) {
        PlatFormCatalog bean = this.check(new PlatFormCatalogId(param.getId()));
        BeanUtils.copyProperties(param, bean);
        platFormCatalogDao.update(bean);
    }

    @Override
    public PlatFormCatalog info(PlatFormCatalogId param) {
        return platFormCatalogDao.selectById(param);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(PlatFormCatalogRemove param) {
        this.check(new PlatFormCatalogId(param.getId()));
        platFormCatalogDao.deleteById(param);
    }

}




