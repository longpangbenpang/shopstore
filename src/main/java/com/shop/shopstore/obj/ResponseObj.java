package com.shop.shopstore.obj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 全局返回对象
 *
 * @param <T>
 */
@Getter
@Setter
public class ResponseObj<T> implements Serializable {
    protected static final long serialVersionUID = 170648828841730907L;
    protected int code;
    protected T data;
    protected boolean status;
    protected String msg;

    public ResponseObj() {
        this.status = true;
        this.code = 200;
        this.msg = "";
    }

    public ResponseObj<T> error(String msg) {
        this.msg = msg;
        this.status = false;
        this.code = 500;
        return this;
    }

    public ResponseObj<T> success(T data) {
        this.status = true;
        this.code = 200;
        this.data = data;
        return this;
    }
}
