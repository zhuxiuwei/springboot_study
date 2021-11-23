package com.xiuwei.booy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类， 主配置类
 * @SpringBootApplication： 这是一个SpringBoot应用，等价于：
     @SpringBootConfiguration
     @EnableAutoConfiguration
     @ComponentScan("com.atguigu.boot")
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //返回的也是个ApplicationContext
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
    }
}