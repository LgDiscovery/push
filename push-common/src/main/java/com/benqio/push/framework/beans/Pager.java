package com.benqio.push.framework.beans;

import com.github.pagehelper.Page;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@SuppressWarnings("serial")
public class Pager<T> implements Serializable{
    
    private List<T> list;
    
    private int pagesize;
    
    private int page;
    
    private int pages;
    
    private long total;
    
    public Pager(List<T> list, int pagesize, int page, long total) {
        this.list = list;
        this.pagesize = pagesize;
        this.page = page;
        this.total = total;
        this.pages = (int) (total + pagesize - 1) / pagesize;
    }
    
    public Pager(Page<T> page) {
        this.list = page.getResult();
        this.page = page.getPageNum();
        this.total = page.getTotal();
        this.pagesize = page.getPageSize();
        this.pages = (int) (total + pagesize - 1) / pagesize;
    }
    
}