package com.benqio.push.framework.beans;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @since 2016-02-15 12:39:51
 * @version v1.0.0
 * @author jinyifeng5969@163.com
 */
@Setter
@Getter
public class IdParam {
    
    @NotNull(message = "ID不能为空")
    private Serializable id;
    
}