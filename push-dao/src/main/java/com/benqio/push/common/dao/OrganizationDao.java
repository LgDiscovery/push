package com.benqio.push.common.dao;

import com.benqio.push.common.model.Organization;
import com.benqio.push.common.vo.organization.*;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 组织机构Dao接口
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-19 19:02:49
 */
public interface OrganizationDao {

    /**
     * 分页查询组织机构记录列表
     */
    List<OrganizationListItem> query(OrganizationList param);

    /**
     * 根据主键查询组织机构记录详情
     */
    Organization selectById(OrganizationId param);

    /**
     * 添加组织机构新纪录
     */
    Organization insert(Organization param);

    /**
     * 根据主键删除组织机构记录
     */
    int deleteById(OrganizationRemove param);

    /**
     * 更新组织机构记录
     */
    int update(Organization param);

    /*获取所有的组织机构*/
    @Select("select * from organization")
    List<Organization> getAllOrganization();
}




