package com.shop.shopstore.obj;

/**
 * 未登录异常
 */
public class NoAuthException extends RuntimeException {
    public NoAuthException(String message) {
        super(message);
    }
}