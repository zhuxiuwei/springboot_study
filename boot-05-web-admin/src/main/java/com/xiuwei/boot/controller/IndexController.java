package com.xiuwei.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    /**
     * 来登录页
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage(){
        return "login";
    }


}
