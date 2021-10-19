package com.xiuwei.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ！！！注意：HelloController需要和"MainApplication"在同一个父级包目录下，否则扫描不到。
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
}
