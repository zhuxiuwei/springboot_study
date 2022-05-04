package com.xiuwei.boot.config;

import com.xiuwei.boot.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * #81 @Profile标记在方法上。不同的配置文件生效，会注册相应的Color类。
 * 测试见MainApplication里。
 */
@Configuration
public class MyConfig {

    @Profile({"prod","default"})    /** 不要忘了默认配置的兜底，加上default */
    @Bean
    public Color red(){
        System.out.println("\"prod\",\"default\"配置生效，注册red Color!");
        return new Color();
    }

    @Profile("test")
    @Bean
    public Color green(){
        System.out.println("\"test\"配置生效，注册green Color");
        return new Color();
    }

}
