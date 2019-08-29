package com.benqio.push.framework.beans;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;
@Getter
@Setter
public class Menu
        implements Serializable
{
    private Long id;
    private String name;
    private Long parentId;
    private String action;
    private String code;
    private Byte sort;
    private Set<Menu> menus;
    private Set<String> funs;


}
