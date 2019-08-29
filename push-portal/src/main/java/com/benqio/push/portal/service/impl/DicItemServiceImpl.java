package com.benqio.push.portal.service.impl;

import com.benqio.push.common.model.DicItem;
import com.benqio.push.common.dao.DicItemDao;
import com.benqio.push.common.vo.dicitem.*;
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
import com.benqio.push.portal.service.DicItemService;
import com.benqio.push.framework.Message;

import javax.annotation.Resource;
import java.util.List;

/**
 * 字典项 服务接口实现类
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-6 11:42:44
 */
@Service
public class DicItemServiceImpl implements DicItemService {

    @Resource
    private DicItemDao dicItemDao;

    @Override
    public PageInfo<DicItemListItem> list(DicItemList param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        PageInfo<DicItemListItem> list = new PageInfo<>(dicItemDao.query(param));
        return list;
    }

    @Override
    public DicItem check(DicItemId param) {
        DicItem bean = dicItemDao.selectById(param);
        Assert.notNull(bean, Message.WARN_BEAN_DOES_NOT_EXIST);
        return bean;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DicItem add(DicItemAdd param) {
        DicItem bean = new DicItem();
        BeanUtils.copyProperties(param, bean);
        //bean.setId(RandomUtil.simpleUUID());
        dicItemDao.insert(bean);
        return bean;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void edit(DicItemEdit param) {
        DicItem bean = this.check(new DicItemId(param.getId()));
        BeanUtils.copyProperties(param, bean);
        dicItemDao.update(bean);
    }

    @Override
    public DicItem info(DicItemId param) {
        return dicItemDao.selectById(param);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(DicItemRemove param) {
        this.check(new DicItemId(param.getId()));
        dicItemDao.deleteById(param);
    }

    /*依据字典类型编码查询字典项集合*/
    @Override
    public List<DicItem> getDicItemByTypeCode(String typeCode) {
        return dicItemDao.getDicItemByTypeCode(typeCode);
    }

}




