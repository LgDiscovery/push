package com.benqio.push.framework.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * @since 2016-02-15 12:39:51
 * @version v1.0.0
 * @author jinyifeng5969@163.com
 */
@Setter
@Getter
@NoArgsConstructor
public class ListData<T> {



    @NotEmpty(message = "list不能为空")
    private List<T> list;

    public ListData(List<T> list) {
        this.list = list;
    }
}