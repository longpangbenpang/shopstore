package com.shop.shopstore.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shop.shopstore.action.base.BaseController;
import com.shop.shopstore.common.utils.SessionUtils;
import com.shop.shopstore.obj.GlobalSession;
import com.shop.shopstore.obj.MsgException;
import com.shop.shopstore.obj.ResponseObj;
import com.shop.shopstore.obj.UnLogin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "login")
public class LoginController extends BaseController {

    @PostMapping
    @UnLogin
    public ResponseObj<Map> login(String account, String password) {
        ResponseObj<Map> responseObj = new ResponseObj();
        Map map = new HashMap<>();
        try {
            //验证是否已经存在token
            if (SessionUtils.getSession() != null) {
                map.put("data", httpServletRequest.getSession().getAttribute(GlobalSession.TOKEN_KEY));
                responseObj.setData(map);
            } else {
                GlobalSession globalSession = JSON.toJavaObject(JSONObject.parseObject("data"), GlobalSession.class);

                map.put("data", "data");
                map.put("user", globalSession);
                responseObj.setData(map);
                httpServletRequest.getSession().setAttribute(GlobalSession.SESSION_KEY, globalSession);
                httpServletRequest.getSession().setAttribute(GlobalSession.TOKEN_KEY, responseObj.getData());
            }
        } catch (MsgException e) {
            responseObj.error(e.getMessage());
        } catch (Exception e) {
            this.ajaxException(getErrorMsg(), e);
        }
        return responseObj;
    }

    @PostMapping(value = "loginout")
    public ResponseObj loginOut() {
        httpServletRequest.getSession().removeAttribute(GlobalSession.SESSION_KEY);
        httpServletRequest.getSession().removeAttribute(GlobalSession.TOKEN_KEY);
        return new ResponseObj().success("true");
    }

}
