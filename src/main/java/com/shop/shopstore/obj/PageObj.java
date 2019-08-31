package com.shop.shopstore.obj;

import com.github.pagehelper.Page;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 分页对象
 */
@Getter
@Setter
public class PageObj implements Serializable {
    private static final long serialVersionUID = -2755861262924856947L;
    private int pages;
    private int page;
    private int pageSize;
    private int totals;
    //是否开启分页
    private boolean needPage;

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotals() {
        return totals;
    }

    public void setTotals(int totals) {
        this.totals = totals;
    }

    public boolean isNeedPage() {
        return needPage;
    }

    public void setNeedPage(boolean needPage) {
        this.needPage = needPage;
    }

    public PageObj parse(Page page){
        this.needPage = true;
        this.page = page.getPageNum();
        this.pages = page.getPages();
        this.pageSize = page.getPageSize();
        this.totals = (int) page.getTotal();
        return this;
    }
}
