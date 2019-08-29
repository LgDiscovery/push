package com.benqio.push.portal.service;

import com.benqio.push.common.model.DicItem;
import com.benqio.push.common.vo.dicitem.*;
import com.github.pagehelper.PageInfo;
import com.benqio.push.framework.beans.Result;
import com.benqio.push.framework.beans.ResultData;
import com.benqio.push.framework.beans.ResultPage;

import java.util.List;

/**
 * 字典项 服务接口
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-6 11:42:44
 */
public interface DicItemService {

    /**
     *字典项列表分页查询
     */
    PageInfo<DicItemListItem> list(DicItemList param);

    /**
     * 检查字典项对象是否存在
     */
    DicItem check(DicItemId param);

    /**
     * 根据主键查询字典项详情
     */
    DicItem info(DicItemId param);

    /**
     * 新增字典项
     */
    DicItem add(DicItemAdd param);

    /**
     * 编辑字典项
     */
    void edit(DicItemEdit param);

    /**
     * 移除字典项
     */
    void remove(DicItemRemove param);

    /**
     * 依据字典类型编码查询字典项集合
     */
    List<DicItem> getDicItemByTypeCode(String typeCode);

}




