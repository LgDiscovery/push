package com.benqio.push.framework.beans;

import com.github.pagehelper.Page;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@SuppressWarnings("serial")
public class BootstrapPager<T> implements Serializable{
    
    private List<T> rows;
    
    private int pageSize;
    
    private int page;
    
    private int pages;
    
    private long total;
    
    public BootstrapPager(List<T> rows, int pageSize, int page, long total) {
        this.rows = rows;
        this.pageSize = pageSize;
        this.page = page;
        this.total = total;
        this.pages = (int) (total + pageSize - 1) / pageSize;
    }
    
    public BootstrapPager(Page<T> page) {
        this.rows = page.getResult();
        this.page = page.getPageNum();
        this.total = page.getTotal();
        this.pageSize = page.getPageSize();
        this.pages = (int) (total + pageSize - 1) / pageSize;
    }
    
}