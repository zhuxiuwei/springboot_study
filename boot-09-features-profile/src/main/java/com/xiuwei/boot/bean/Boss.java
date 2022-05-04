package com.xiuwei.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
/**
 * #81：@Profile标记在类上，只有prod和默认环境才注册Boss到容器里。
 * ！！！注意，如果不加上default，而且application.properties里没有指定生效配置文件（即默认配置文件）时，会导致容器Autowire Person类失败而无法启动！！！
 */
@Profile({"prod","default"})
@ConfigurationProperties("person")
@Data
public class Boss implements Person{
    private String name;
    private Integer age;
}
