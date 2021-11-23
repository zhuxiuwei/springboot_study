package com.xiuwei.booy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 测试请求URL，和静态资源地址(META-INF/resources/1.jpeg)，冲突了会怎么样
    // 测试结果：会优先执行controller。 就是浏览器打印aaa
    @RequestMapping("/1.jpeg")
    public String hello(){
        return "aaa";
    }
}
