package com.benqio.push.common.vo.platformdevice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 平台设备主键Id
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-18 15:11:35
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "平台设备主键Id")
public class PlatFormDeviceId{

    /**
     * 主键ID
     */
    @NotNull
    @ApiModelProperty(value = "主键ID")
    private Integer id;



}




