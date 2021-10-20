package com.xiuwei.boot.config;

import com.xiuwei.boot.bean.Pet;
import com.xiuwei.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1. 配置类。 @Bean标签给容器注册组件。
 * 2. 配置类本身也是组件（被容器托管）
 * 3. proxyBeanMethods: 代理Bean的方法
 *      Full(proxyBeanMethods = true): 1. 配置类容器中保存的是代理对象； 2. 配置类获取组件，总会检查容器中是否已有组件，保持单例
 *      Lite(proxyBeanMethods = false): 2. 配置类容器中保存的不是代理对象； 2. 配置类获取组件，总会产生一个新对象。 优点：速度快。
 *
 */
@Configuration(proxyBeanMethods = true) //告诉springboot这是一个配置类，可以省略xml文件了。
public class MyConfig {

    @Bean   //方法名为组件id，返回类型为组件类型。返回值就是组件在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean
    public Pet tomcatPet(){
        return new Pet("tom cat");
    }
}
