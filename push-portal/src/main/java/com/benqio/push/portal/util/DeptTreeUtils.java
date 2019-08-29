package com.benqio.push.portal.util;

import com.alibaba.fastjson.JSONArray;
import com.benqio.uc.common.vo.dept.DeptItemTree;
import com.benqio.push.framework.beans.ResultJSONObject;
import com.benqio.push.portal.config.SsoConfig;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 获取部门树方法
 *
 * @author zengchao@benqio.com
 * @since 2018-07-03 14:00:00
 * @version v1.0.0
 */
public class DeptTreeUtils {



    /** 获取部门关联的树结构 */
    public List<DeptItemTree> getDeptItemTree(RestTemplate restTemplate,String url,Map<Long,List<DeptItemTree>> itemMap){
        List<DeptItemTree> itemTrees = new ArrayList<>();
        //获取部门列表
        Map<Long,List<DeptItemTree>> listMap = this.getAllDeptList(restTemplate,url);
        itemTrees.addAll(listMap.get(0L));
        this.buildItemTree(itemTrees,listMap,itemMap);
        return itemTrees;
    }

    /** 根据主部门列表，所有部门的map集合，目标 */
    public void buildItemTree(List<DeptItemTree> itemTreeList,Map<Long,List<DeptItemTree>> listMap,Map<Long,List<DeptItemTree>> itemMap){
        if(CollectionUtils.isNotEmpty(itemTreeList) && !itemMap.isEmpty()){
            for(DeptItemTree tree : itemTreeList){
                List<DeptItemTree> children = new ArrayList<>();
                List<DeptItemTree> deptItemTreeList = new ArrayList<>();
                if(CollectionUtils.isNotEmpty(listMap.get(tree.getId()))){
                    deptItemTreeList.addAll(listMap.get(tree.getId()));
                    children.addAll(deptItemTreeList);
                }
                if(CollectionUtils.isNotEmpty(itemMap.get(tree.getId()))){
                    children.addAll(itemMap.get(tree.getId()));
                }
                tree.setChildren(children);
                if(CollectionUtils.isNotEmpty(deptItemTreeList)){
                    this.buildItemTree(deptItemTreeList,listMap,itemMap);
                }
            }
        }
    }

    //获取所有部门列表
    public Map<Long,List<DeptItemTree>> getAllDeptList(RestTemplate restTemplate,String url){
        Map<Long,List<DeptItemTree>> listMap = new HashMap<>();
        ResultJSONObject result = restTemplate.getForObject(url+"api/dept/deptLists",ResultJSONObject.class);
        if(0 == result.getCode() && !Objects.isNull(result.getData())){
            JSONArray array = result.getData().getJSONArray("list");
            List<DeptItemTree> treeList = new ArrayList<>();
            Set<Long> ids = new HashSet<>();
            ids.add(0L);
            for (int i = 0; i < array.size(); i++) {
                DeptItemTree tree = new DeptItemTree();
                tree.setId(array.getJSONObject(i).getLong("id"));
                tree.setParentId(array.getJSONObject(i).getLong("parentId"));
                tree.setName(array.getJSONObject(i).getString("name"));
                tree.setType("dept");
                treeList.add(tree);
                ids.add(tree.getId());
            }
            for(Long id : ids) {
                List<DeptItemTree> treeLists = new ArrayList<>();
                for(DeptItemTree tree : treeList){
                    if(id == tree.getParentId()){
                        treeLists.add(tree);
                    }
                }
                if(CollectionUtils.isNotEmpty(treeLists)){
                    listMap.put(id,treeLists);
                }
            }
        }
        return listMap;
    }

}
