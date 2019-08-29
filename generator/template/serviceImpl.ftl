package ${package};

import ${tableClass.fullClassName};
import com.benqio.push.common.dao.${tableClass.shortClassName}Dao;
import com.benqio.push.common.vo.${tableClass.shortClassName?lower_case}.*;
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
import com.benqio.push.portal.service.${tableClass.shortClassName}Service;
import com.benqio.push.framework.Message;

import javax.annotation.Resource;

/**
 * ${tableClass.introspectedTable.fullyQualifiedTable.remark} 服务接口实现类
 *
 * @author YangGuang
 * @version v1.0.0
 * @since ${.now}
 */
@Service
public class ${tableClass.shortClassName}ServiceImpl implements ${tableClass.shortClassName}Service {

    @Resource
    private ${tableClass.shortClassName}Dao ${tableClass.shortClassName?uncap_first}Dao;

    @Override
    public PageInfo<${tableClass.shortClassName}ListItem> list(${tableClass.shortClassName}List param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        PageInfo<${tableClass.shortClassName}ListItem> list = new PageInfo<>(${tableClass.shortClassName?uncap_first}Dao.query(param));
        return list;
    }

    @Override
    public ${tableClass.shortClassName} check(${tableClass.shortClassName}Id param) {
        ${tableClass.shortClassName} bean = ${tableClass.shortClassName?uncap_first}Dao.selectById(param);
        Assert.notNull(bean, Message.WARN_BEAN_DOES_NOT_EXIST);
        return bean;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ${tableClass.shortClassName} add(${tableClass.shortClassName}Add param) {
        ${tableClass.shortClassName} bean = new ${tableClass.shortClassName}();
        BeanUtils.copyProperties(param, bean);
        //bean.setId(RandomUtil.simpleUUID());
        ${tableClass.shortClassName?uncap_first}Dao.insert(bean);
        return bean;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void edit(${tableClass.shortClassName}Edit param) {
        ${tableClass.shortClassName} bean = this.check(new ${tableClass.shortClassName}Id(param.getId()));
        BeanUtils.copyProperties(param, bean);
        ${tableClass.shortClassName?uncap_first}Dao.update(bean);
    }

    @Override
    public ${tableClass.shortClassName} info(${tableClass.shortClassName}Id param) {
        return ${tableClass.shortClassName?uncap_first}Dao.selectById(param);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(${tableClass.shortClassName}Remove param) {
        this.check(new ${tableClass.shortClassName}Id(param.getId()));
        ${tableClass.shortClassName?uncap_first}Dao.deleteById(param);
    }

}




