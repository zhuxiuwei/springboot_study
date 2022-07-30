package com.xiuwei.hello.auto;

import com.xiuwei.hello.bean.HelloProperties;
import com.xiuwei.hello.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloProperties.class)   //也会默认把HelloProperties放到容器中
public class HelloServiceAutoConfiguration {

    @Bean
    /*
     ！！！注意@ConditionalOnMissingBean没有写到class上，而是写到方法上。
     否则如果类上的@ConditionalOnMissingBean(HelloService.class)没有执行到，则此类上的注解"@EnableConfigurationProperties(HelloProperties.class)"也会不生效，
     会导致客户端（如boot-10-custom-starter-test的boot.config.MyConfig）主动生成并注册HelloService时，启动App会报错HelloProperties找不到：
     Field helloProperties in com.xiuwei.hello.service.HelloService required a bean of type 'com.xiuwei.hello.bean.HelloProperties' that could not be found.
     */
    @ConditionalOnMissingBean(HelloService.class)
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        return helloService;
    }
}
