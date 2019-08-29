package com.benqio.push.framework.beans;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by jinyifeng on 15/9/12.
 */
@SuppressWarnings("serial")
@Setter
@Getter
public class Id implements Serializable{
    
    private Serializable id;
    
    public Id(Serializable id) {
        this.id = id;
    }
    
}