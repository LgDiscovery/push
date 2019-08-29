package com.benqio.push.portal.service;

import com.benqio.push.common.model.DicType;
import com.benqio.push.common.vo.dictype.*;
import com.github.pagehelper.PageInfo;
import com.benqio.push.framework.beans.Result;
import com.benqio.push.framework.beans.ResultData;
import com.benqio.push.framework.beans.ResultPage;

/**
 * 字典类型 服务接口
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-6 11:42:44
 */
public interface DicTypeService {

    /**
     *字典类型列表分页查询
     */
    PageInfo<DicTypeListItem> list(DicTypeList param);

    /**
     * 检查字典类型对象是否存在
     */
    DicType check(DicTypeId param);

    /**
     * 根据主键查询字典类型详情
     */
    DicType info(DicTypeId param);

    /**
     * 新增字典类型
     */
    DicType add(DicTypeAdd param);

    /**
     * 编辑字典类型
     */
    void edit(DicTypeEdit param);

    /**
     * 移除字典类型
     */
    void remove(DicTypeRemove param);

}




