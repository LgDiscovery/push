package com.benqio.push.common.vo.platformdevice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 移除平台设备参数
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-12-18 15:11:35
 */
@Setter
@Getter
@ApiModel(value = "移除平台设备参数")
public class PlatFormDeviceRemove extends PlatFormDeviceId {

}




