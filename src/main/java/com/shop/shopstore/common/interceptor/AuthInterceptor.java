package com.shop.shopstore.common.interceptor;

import com.shop.shopstore.obj.GlobalSession;
import com.shop.shopstore.obj.NoAuthException;
import com.shop.shopstore.obj.UnLogin;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (handlerMethod.hasMethodAnnotation(UnLogin.class)) {
                return true;
            }
            if (request.getSession().getAttribute(GlobalSession.SESSION_KEY) != null) {
                return true;
            } else {
                throw new NoAuthException("Not Login！");
            }
        }
        return true;
    }
}
