package com.benqio.push.common.vo.dictype;

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
 * 字典类型列表查询参数
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-6 11:42:44
 */
@Setter
@Getter
@NoArgsConstructor
@ApiModel(value = "字典类型列表查询参数")
public class DicTypeList extends PageParam {

    /**
     * ID编号
     */
    @ApiModelProperty(value = "ID编号")
    private Integer id;

    /**
     * 字典类型编码
     */
    @ApiModelProperty(value = "字典类型编码")
    private String code;

    /**
     * 字典类型名称
     */
    @ApiModelProperty(value = "字典类型名称")
    @NotBlank
    private String name;

    /**
     * 字典类型状态:0.禁用、1.正常
     */
    @ApiModelProperty(value = "字典类型状态:0.禁用、1.正常")
    private Byte state;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}




