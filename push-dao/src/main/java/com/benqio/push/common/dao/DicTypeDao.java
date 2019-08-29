package com.benqio.push.common.dao;

import com.benqio.push.common.model.DicType;
import com.benqio.push.common.vo.dictype.*;
import java.util.List;

/**
 * 字典类型Dao接口
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-6 11:42:44
 */
public interface DicTypeDao {

    /**
     * 分页查询字典类型记录列表
     */
    List<DicTypeListItem> query(DicTypeList param);

    /**
     * 根据主键查询字典类型记录详情
     */
    DicType selectById(DicTypeId param);

    /**
     * 添加字典类型新纪录
     */
    DicType insert(DicType param);

    /**
     * 根据主键删除字典类型记录
     */
    int deleteById(DicTypeRemove param);

    /**
     * 更新字典类型记录
     */
    int update(DicType param);

}




