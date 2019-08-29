package ${package};

import ${tableClass.fullClassName};
import com.benqio.push.common.vo.${tableClass.shortClassName?lower_case}.*;
import com.github.pagehelper.PageInfo;
import com.benqio.push.framework.beans.Result;
import com.benqio.push.framework.beans.ResultData;
import com.benqio.push.framework.beans.ResultPage;

/**
 * ${tableClass.introspectedTable.fullyQualifiedTable.remark} 服务接口
 *
 * @author YangGuang
 * @version v1.0.0
 * @since ${.now}
 */
public interface ${tableClass.shortClassName}Service {

    /**
     *${tableClass.introspectedTable.fullyQualifiedTable.remark}列表分页查询
     */
    PageInfo<${tableClass.shortClassName}ListItem> list(${tableClass.shortClassName}List param);

    /**
     * 检查${tableClass.introspectedTable.fullyQualifiedTable.remark}对象是否存在
     */
    ${tableClass.shortClassName} check(${tableClass.shortClassName}Id param);

    /**
     * 根据主键查询${tableClass.introspectedTable.fullyQualifiedTable.remark}详情
     */
    ${tableClass.shortClassName} info(${tableClass.shortClassName}Id param);

    /**
     * 新增${tableClass.introspectedTable.fullyQualifiedTable.remark}
     */
    ${tableClass.shortClassName} add(${tableClass.shortClassName}Add param);

    /**
     * 编辑${tableClass.introspectedTable.fullyQualifiedTable.remark}
     */
    void edit(${tableClass.shortClassName}Edit param);

    /**
     * 移除${tableClass.introspectedTable.fullyQualifiedTable.remark}
     */
    void remove(${tableClass.shortClassName}Remove param);

}




