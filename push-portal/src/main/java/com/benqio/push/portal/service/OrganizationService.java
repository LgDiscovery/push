package com.benqio.push.portal.service;

import com.benqio.push.common.model.Organization;
import com.benqio.push.common.vo.organization.*;
import com.github.pagehelper.PageInfo;
import com.benqio.push.framework.beans.Result;
import com.benqio.push.framework.beans.ResultData;
import com.benqio.push.framework.beans.ResultPage;

import java.util.List;

/**
 * 组织机构 服务接口
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-19 19:02:49
 */
public interface OrganizationService {

    /**
     *组织机构列表分页查询
     */
    PageInfo<OrganizationListItem> list(OrganizationList param);

    /**
     * 检查组织机构对象是否存在
     */
    Organization check(OrganizationId param);

    /**
     * 根据主键查询组织机构详情
     */
    Organization info(OrganizationId param);

    /**
     * 新增组织机构
     */
    Organization add(OrganizationAdd param);

    /**
     * 编辑组织机构
     */
    void edit(OrganizationEdit param);

    /**
     * 移除组织机构
     */
    void remove(OrganizationRemove param);

    /**
     *获取所有的组织机构
     */
    List<Organization> getAllOrganization();

}




