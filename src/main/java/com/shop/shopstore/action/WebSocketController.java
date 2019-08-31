package com.shop.shopstore.action;

import com.shop.shopstore.obj.ResponseObj;
import com.shop.shopstore.obj.UnLogin;
import com.shop.shopstore.service.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * websockert消息推送
 */
@Controller
@RequestMapping("/checkcenter")
public class WebSocketController {

    @Autowired
    private WebSocketServer webSocketServer;

    //页面请求
    @GetMapping("/socket/{cid}")
    @UnLogin
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav = new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return mav;
    }

    //推送数据接口
    @ResponseBody
    @UnLogin
    @RequestMapping("/socket/push/{cid}")
    public ResponseObj<String> pushToWeb(@PathVariable String cid, String message) {
        try {
            WebSocketServer.sendInfo(message, cid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseObj<>();
    }
}
