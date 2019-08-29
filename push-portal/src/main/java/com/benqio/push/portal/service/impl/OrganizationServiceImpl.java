package com.benqio.push.portal.service.impl;

import com.benqio.push.common.model.Organization;
import com.benqio.push.common.dao.OrganizationDao;
import com.benqio.push.common.vo.organization.*;
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
import com.benqio.push.portal.service.OrganizationService;
import com.benqio.push.framework.Message;

import javax.annotation.Resource;
import java.util.List;

/**
 * 组织机构 服务接口实现类
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-19 19:02:49
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Resource
    private OrganizationDao organizationDao;

    @Override
    public PageInfo<OrganizationListItem> list(OrganizationList param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        PageInfo<OrganizationListItem> list = new PageInfo<>(organizationDao.query(param));
        return list;
    }

    @Override
    public Organization check(OrganizationId param) {
        Organization bean = organizationDao.selectById(param);
        Assert.notNull(bean, Message.WARN_BEAN_DOES_NOT_EXIST);
        return bean;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Organization add(OrganizationAdd param) {
        Organization bean = new Organization();
        BeanUtils.copyProperties(param, bean);
        //bean.setId(RandomUtil.simpleUUID());
        organizationDao.insert(bean);
        return bean;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void edit(OrganizationEdit param) {
        Organization bean = this.check(new OrganizationId(param.getId()));
        BeanUtils.copyProperties(param, bean);
        organizationDao.update(bean);
    }

    @Override
    public Organization info(OrganizationId param) {
        return organizationDao.selectById(param);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(OrganizationRemove param) {
        this.check(new OrganizationId(param.getId()));
        organizationDao.deleteById(param);
    }

    /*获取所有的组织机构*/
    @Override
    public List<Organization> getAllOrganization() {
        return organizationDao.getAllOrganization();
    }

}




