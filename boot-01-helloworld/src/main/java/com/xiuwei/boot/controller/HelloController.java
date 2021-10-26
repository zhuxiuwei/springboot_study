package com.xiuwei.boot.controller;

import com.xiuwei.boot.bean.Car;
import com.xiuwei.boot.bean.Car2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * ！！！注意：HelloController需要和"MainApplication"在同一个父级包目录下，否则扫描不到。
 */
@RestController
public class HelloController {

    @Autowired
    private Car car;
    @Autowired
    private Car2 car2;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    @RequestMapping("/car2")
    public Car2 car2(){
        return car2;
    }
}
