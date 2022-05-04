package com.xiuwei.boot.controller;

import com.xiuwei.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// #82 尝试读取系统环境变量信息
@RestController
public class SystemEnvironmentInfoController {

    @Value("${os.name}")    //来自jvm属性
    private String osName;

    @Value("${JAVA_HOME}")  //来自环境变量
    private String javaHome;

    @GetMapping("/envInfo")
    public String person(){
        StringBuilder sb = new StringBuilder();
        sb.append("${JAVA_HOME}=");
        sb.append(javaHome);

        sb.append("</br>");
        sb.append("${os.name}=");
        sb.append(osName);
        return sb.toString();
        /**
         * ${JAVA_HOME}=/Library/Java/JavaVirtualMachines/jdk1.8.0_251.jdk/Contents/Home
         * ${os.name}=Mac OS X
         */
    }
}
