package com.xiuwei.booy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {

    //thymeLeaf 初体验
    @GetMapping("thymeLeaf101")
    public String thymeLeaf101(Model model){

        //model中的数据会被放到请求域中 相当于： request.setAttribute("foo","bar")
        model.addAttribute("msg", "hello thymeLeaf!");
        model.addAttribute("link", "http://www.baidu.com");

        return "success";
    }
}
