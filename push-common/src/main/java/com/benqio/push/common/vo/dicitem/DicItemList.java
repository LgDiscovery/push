package com.benqio.push.common.vo.dicitem;

import com.benqio.push.framework.beans.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 字典项列表查询参数
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-6 11:42:44
 */
@Setter
@Getter
@NoArgsConstructor
@ApiModel(value = "字典项列表查询参数")
public class DicItemList extends PageParam {

    /**
     * ID编号
     */
    @ApiModelProperty(value = "ID编号")
    private Integer id;

    /**
     * 字典项编码
     */
    @ApiModelProperty(value = "字典项编码")
    private String code;

    /**
     * 字典项名称
     */
    @ApiModelProperty(value = "字典项名称")
    private String name;

    /**
     * 字典类型编码
     */
    @ApiModelProperty(value = "字典类型编码")
    private String typeCode;

    /**
     * 设定值
     */
    @ApiModelProperty(value = "设定值")
    private String value;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 字典项状态:0.禁用、1.正常
     */
    @ApiModelProperty(value = "字典项状态:0.禁用、1.正常")
    private Byte state;

    /**
     * 标识:0删除，1未删除
     */
    @ApiModelProperty(value = "标识:0删除，1未删除")
    private Byte sign;

    /**
     * 图标
     */
    @ApiModelProperty(value = "图标")
    private String icon;

    /**
     * 倒计时状态:0.不启用 1.启用
     */
    @ApiModelProperty(value = "倒计时状态:0.不启用 1.启用")
    private Byte countState;

}




