package ${package};

import ${tableClass.fullClassName};
import com.benqio.push.common.vo.${tableClass.shortClassName?lower_case}.*;
import java.util.List;

/**
 * ${tableClass.introspectedTable.fullyQualifiedTable.remark}Dao接口
 *
 * @author YangGuang
 * @version v1.0.0
 * @since ${.now}
 */
public interface ${tableClass.shortClassName}Dao {

    /**
     * 分页查询${tableClass.introspectedTable.fullyQualifiedTable.remark}记录列表
     */
    List<${tableClass.shortClassName}ListItem> query(${tableClass.shortClassName}List param);

    /**
     * 根据主键查询${tableClass.introspectedTable.fullyQualifiedTable.remark}记录详情
     */
    ${tableClass.shortClassName} selectById(${tableClass.shortClassName}Id param);

    /**
     * 添加${tableClass.introspectedTable.fullyQualifiedTable.remark}新纪录
     */
    ${tableClass.shortClassName} insert(${tableClass.shortClassName} param);

    /**
     * 根据主键删除${tableClass.introspectedTable.fullyQualifiedTable.remark}记录
     */
    int deleteById(${tableClass.shortClassName}Remove param);

    /**
     * 更新${tableClass.introspectedTable.fullyQualifiedTable.remark}记录
     */
    int update(${tableClass.shortClassName} param);

}




