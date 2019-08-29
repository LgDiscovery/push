package com.benqio.push.common.dao;

import com.benqio.push.common.model.DicItem;
import com.benqio.push.common.vo.dicitem.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 字典项Dao接口
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-6 11:42:44
 */
public interface DicItemDao {

    /**
     * 分页查询字典项记录列表
     */
    List<DicItemListItem> query(DicItemList param);

    /**
     * 根据主键查询字典项记录详情
     */
    DicItem selectById(DicItemId param);

    /**
     * 添加字典项新纪录
     */
    DicItem insert(DicItem param);

    /**
     * 根据主键删除字典项记录
     */
    int deleteById(DicItemRemove param);

    /**
     * 更新字典项记录
     */
    int update(DicItem param);

    /*依据字典类型编码查询字典项集合*/
    @Select("select * from dic_item where `type_code` =#{typeCode}")
    List<DicItem> getDicItemByTypeCode(@Param("typeCode") String typeCode);
}




