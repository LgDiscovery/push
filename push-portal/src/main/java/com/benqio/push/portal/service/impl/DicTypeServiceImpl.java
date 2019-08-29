package com.benqio.push.portal.service.impl;

import com.benqio.push.common.model.DicType;
import com.benqio.push.common.dao.DicTypeDao;
import com.benqio.push.common.vo.dictype.*;
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
import com.benqio.push.portal.service.DicTypeService;
import com.benqio.push.framework.Message;

import javax.annotation.Resource;

/**
 * 字典类型 服务接口实现类
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-6 11:42:44
 */
@Service
public class DicTypeServiceImpl implements DicTypeService {

    @Resource
    private DicTypeDao dicTypeDao;

    @Override
    public PageInfo<DicTypeListItem> list(DicTypeList param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        PageInfo<DicTypeListItem> list = new PageInfo<>(dicTypeDao.query(param));
        return list;
    }

    @Override
    public DicType check(DicTypeId param) {
        DicType bean = dicTypeDao.selectById(param);
        Assert.notNull(bean, Message.WARN_BEAN_DOES_NOT_EXIST);
        return bean;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DicType add(DicTypeAdd param) {
        DicType bean = new DicType();
        BeanUtils.copyProperties(param, bean);
        //bean.setId(RandomUtil.simpleUUID());
        dicTypeDao.insert(bean);
        return bean;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void edit(DicTypeEdit param) {
        DicType bean = this.check(new DicTypeId(param.getId()));
        BeanUtils.copyProperties(param, bean);
        dicTypeDao.update(bean);
    }

    @Override
    public DicType info(DicTypeId param) {
        return dicTypeDao.selectById(param);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(DicTypeRemove param) {
        this.check(new DicTypeId(param.getId()));
        dicTypeDao.deleteById(param);
    }

}




