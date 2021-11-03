package com.xiuwei.controller;

import com.xiuwei.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    Person person;

    @RequestMapping("/hello")
    public Person hello(){
        //用于测试单引号、双引号在yaml value里的不同效果。
        System.out.println(person.getUserName());
        return person;
    }
}
