package com.shop.shopstore.common.utils;

import com.shop.shopstore.obj.GlobalSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 缓存工具类
 * Created by Long on 2019/4/11.
 */
public class SessionUtils {

    public static GlobalSession getSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object gs = request.getSession().getAttribute(GlobalSession.SESSION_KEY);
        if (gs != null) {
            return (GlobalSession) gs;
        }
        return null;
    }
}
