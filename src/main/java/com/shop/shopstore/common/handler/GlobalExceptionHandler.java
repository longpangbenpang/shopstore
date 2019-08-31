package com.shop.shopstore.common.handler;

import com.shop.shopstore.obj.MsgException;
import com.shop.shopstore.obj.NoAuthException;
import com.shop.shopstore.obj.ResponseObj;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private Log log = LogFactory.getLog(GlobalExceptionHandler.class);

    @ExceptionHandler(value = MsgException.class)
    public ResponseObj jsonMsgError(Exception e) {
        e.printStackTrace();
        log.error(e);
        return new ResponseObj().error(e.getMessage());
    }

    @ExceptionHandler(value = NoAuthException.class)
    public ResponseObj noAUthMsgError(Exception e) {
        ResponseObj responseObj = new ResponseObj();
        responseObj.setCode(300);
        responseObj.setStatus(false);
        responseObj.setMsg(e.getMessage());
        return responseObj;
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseObj jsonError(Exception e) {
        e.printStackTrace();
        log.error(e);
        return new ResponseObj().error("服务器异常");
    }
}
