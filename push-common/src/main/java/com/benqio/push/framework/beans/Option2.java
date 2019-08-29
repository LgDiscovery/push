package com.benqio.push.framework.beans;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@SuppressWarnings("serial")
public class Option2<T extends Serializable> implements Serializable {
    
    private T value;
    
    private String text;
    
}