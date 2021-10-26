package com.xiuwei.boot;

import com.xiuwei.boot.bean.Pet;
import com.xiuwei.boot.bean.User;
import com.xiuwei.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 主程序类， 主配置类
 * @SpringBootApplication： 这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //返回的也是个ApplicationContext
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //可以查看所有被管理的bean。自己如果注册了bean也会打印。
        for (String beanDefinitionName : run.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        //从容器中获取组件
        Pet tom01 = run.getBean("tomcatPet", Pet.class);
        Pet tom02 = run.getBean("tomcatPet", Pet.class);
        System.out.println("从容器中获取组件:" + (tom01 == tom02));     //默认单例模式，应该是true

        /**
         * MyConfig.java, @Configuration(proxyBeanMethods = true):
         *      com.xiuwei.boot.config.MyConfig$$EnhancerBySpringCGLIB$$c1649a24@b34832b，是代理
         * MyConfig.java, @Configuration(proxyBeanMethods = false):
         *      com.xiuwei.boot.config.MyConfig@7add838c，不是代理
         */
        MyConfig myConfig = run.getBean(MyConfig.class);
        System.out.println("myConfig: " + myConfig);

        /**
         * MyConfig.java, @Configuration(proxyBeanMethods = true): true。因为此时，springboot总会检查这个组件容器中是否已有。即总会保持单实例。
         * MyConfig.java, @Configuration(proxyBeanMethods = false): false
         */
        User u1 = myConfig.user01();
        User u2 = myConfig.user01();
        System.out.println("myConfig中调用方法获取组件：" + (u1 == u2));

        /**
         * 组件依赖
         * MyConfig.java, @Configuration(proxyBeanMethods = true): true。因为此时，springboot总会检查这个组件容器中是否已有。即总会保持单实例。
         * MyConfig.java, @Configuration(proxyBeanMethods = false): false
         */
        Pet pet = run.getBean("tomcatPet", Pet.class);
        System.out.println("依赖引用：" + (pet == u1.getPet()));

        //测试@Import标签
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
            /**
             * 结果：
             * com.xiuwei.boot.bean.User  -- ！！为MyConfig.java的@Import({User.class, DBHelper.class})标签注入的
             * user01  -- MyConfig里@Bean标签注入的
             */
        }

        //测试ConditionalOnMissingBean标签
        System.out.println(run.containsBean("conditionPet")); //false。不满足条件bean未创建。

        //测试@ImportResource标签
        //MyConfig.java里配置了：@ImportResource("classpath:beans.xml")
        System.out.println(run.containsBean("haha"));   //true
    }
}