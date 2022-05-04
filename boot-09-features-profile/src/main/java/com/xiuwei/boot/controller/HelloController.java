package com.xiuwei.boot.controller;

import com.xiuwei.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${person.name:默认值}")
    private String name;

    @Autowired
    private Person person;

    @GetMapping("/hi")
    public String hi(){
        System.out.println(name);
        return "hi " + name;
    }

    @GetMapping("/person")
    public Person person(){
        System.out.println(person.getClass().getName());    //观察是哪个Person子类生效
        return person;
    }
}
