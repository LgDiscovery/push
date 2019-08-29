package com.benqio.push.portal.service;

import com.benqio.push.common.model.PlatFormCatalog;
import com.benqio.push.common.vo.platformcatalog.*;
import com.github.pagehelper.PageInfo;
import com.benqio.push.framework.beans.Result;
import com.benqio.push.framework.beans.ResultData;
import com.benqio.push.framework.beans.ResultPage;

/**
 * 平台地区 服务接口
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-4 19:38:07
 */
public interface PlatFormCatalogService {

    /**
     *平台地区列表分页查询
     */
    PageInfo<PlatFormCatalogListItem> list(PlatFormCatalogList param);

    /**
     * 检查平台地区对象是否存在
     */
    PlatFormCatalog check(PlatFormCatalogId param);

    /**
     * 根据主键查询平台地区详情
     */
    PlatFormCatalog info(PlatFormCatalogId param);

    /**
     * 新增平台地区
     */
    PlatFormCatalog add(PlatFormCatalogAdd param);

    /**
     * 编辑平台地区
     */
    void edit(PlatFormCatalogEdit param);

    /**
     * 移除平台地区
     */
    void remove(PlatFormCatalogRemove param);

}




