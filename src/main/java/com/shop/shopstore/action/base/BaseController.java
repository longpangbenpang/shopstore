package com.shop.shopstore.action.base;

import com.shop.shopstore.obj.MsgException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Long on 2019/4/4.
 * 基础控制
 */
public abstract class BaseController {
    protected Log log = LogFactory.getLog(BaseController.class);

    @Autowired
    protected HttpServletRequest httpServletRequest;

    protected void ajaxException(String msg, Exception e) {
        log.error(e);
        e.printStackTrace();
        throw new MsgException(msg);
    }

    protected String getErrorMsg() {
        return "errot";
    }
}
