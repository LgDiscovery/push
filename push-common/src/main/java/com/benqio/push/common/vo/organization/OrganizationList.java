package com.benqio.push.common.vo.organization;

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
 * 组织机构列表查询参数
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-19 19:02:49
 */
@Setter
@Getter
@NoArgsConstructor
@ApiModel(value = "组织机构列表查询参数")
public class OrganizationList extends PageParam {

    /**
     * ID编号
     */
    @ApiModelProperty(value = "ID编号")
    private Integer id;

    /**
     * 组织机构编号
     */
    @ApiModelProperty(value = "组织机构编号")
    @NotBlank
    private String code;

    /**
     * 组织机构名称
     */
    @ApiModelProperty(value = "组织机构名称")
    @NotBlank
    private String name;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 状态：0未启用，1启用
     */
    @ApiModelProperty(value = "状态：0未启用，1启用")
    private Byte state;

    /**
     * 监狱类型：0不是 1是
     */
    @ApiModelProperty(value = "监狱类型：0不是 1是")
    private Byte type;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date create_time;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date update_time;

}




