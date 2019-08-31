package com.shop.shopstore.obj;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseWithPageObj<T> extends ResponseObj<T> {
    private PageObj pageObj;

    public PageObj getPageObj() {
        return pageObj;
    }

    public void setPageObj(PageObj pageObj) {
        this.pageObj = pageObj;
    }
}
