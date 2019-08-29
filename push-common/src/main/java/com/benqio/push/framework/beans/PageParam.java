package com.benqio.push.framework.beans;


import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * 分页参数
 * @since 2016-02-15 12:39:51
 * @version v1.0.0
 * @author jinyifeng5969@163.com
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageParam implements Serializable {

    @Min(1L)
    private int pageIndex = 1;
    
    @Range(min = 1, max = Integer.MAX_VALUE)
    private int pageSize = 20;
}