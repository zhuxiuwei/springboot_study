package boot.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * #86 原理解析-自定义事件监听组件
 * 自己实现一个ApplicationContextInitializer组件。
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        System.out.println("MyApplicationContextInitializer... initialized!");

        //.....针对applicationContext的各种操作....
    }
}