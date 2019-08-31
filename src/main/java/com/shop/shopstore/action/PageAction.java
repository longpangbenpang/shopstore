package com.shop.shopstore.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "login")
@Controller
public class PageAction {
    @GetMapping
    public String login(){
        //url指定参数 ?i18n_language=zh_CN
        return "login/login";
    }
}
