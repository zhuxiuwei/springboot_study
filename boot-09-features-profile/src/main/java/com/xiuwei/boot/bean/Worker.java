package com.xiuwei.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")    //#81：@Profile标记在类上，只有test环境才注册Boss到容器里。
@ConfigurationProperties("person")
@Data
public class Worker implements Person{
    private String name;
    private Integer age;
}
