package com.xiuwei.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.xiuwei.boot.bean.Car2;
import com.xiuwei.boot.bean.Pet;
import com.xiuwei.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 1. 配置类。 @Bean标签给容器注册组件。
 * 2. 配置类本身也是组件（被容器托管）
 * 3. proxyBeanMethods: 代理Bean的方法
 *      Full(proxyBeanMethods = true): 1. 配置类容器中保存的是代理对象； 2. 配置类获取组件，总会检查容器中是否已有组件，保持单例
 *      Lite(proxyBeanMethods = false): 2. 配置类容器中保存的不是代理对象； 2. 配置类获取组件，总会产生一个新对象。 优点：速度快。
 * 4. @Import({User.class, DBHelper.class})
 *      给容器中自动创建出这两个类型的组件，默认组件的名字就是全类名。
 * 5. @ImportResource：导入spring配置文件
 */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true) //告诉springboot这是一个配置类，可以省略xml文件了。
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car2.class)  //1. 开启Car2配置绑定功能 2.把Car2自动注册到容器中。
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

    //Conditional标签测试：ConditionalOnBean - 名字NOT_EXIST的bean存在时，才创建名字为conditionPetTomcat的Pet。
    @Bean
    @ConditionalOnBean(name = "NOT_EXIST")
    public Pet conditionPet(){
        return new Pet("conditionPetTomcat");
    }
}
