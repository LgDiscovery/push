package com.benqio.push.common.dao;

import com.benqio.push.common.model.PlatFormCatalog;
import com.benqio.push.common.vo.platformcatalog.*;
import java.util.List;

/**
 * 平台地区Dao接口
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-4 19:38:07
 */
public interface PlatFormCatalogDao {

    /**
     * 分页查询平台地区记录列表
     */
    List<PlatFormCatalogListItem> query(PlatFormCatalogList param);

    /**
     * 根据主键查询平台地区记录详情
     */
    PlatFormCatalog selectById(PlatFormCatalogId param);

    /**
     * 添加平台地区新纪录
     */
    PlatFormCatalog insert(PlatFormCatalog param);

    /**
     * 根据主键删除平台地区记录
     */
    int deleteById(PlatFormCatalogRemove param);

    /**
     * 更新平台地区记录
     */
    int update(PlatFormCatalog param);

}




