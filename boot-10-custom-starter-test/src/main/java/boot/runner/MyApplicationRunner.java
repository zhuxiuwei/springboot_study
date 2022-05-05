package boot.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * #86 原理解析-自定义事件监听组件
 * 自己实现一个ApplicationRunner组件。
 */
@Component
@Order(12)   //可以定义启动顺序，数字小的优先极高先启动
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyApplicationRunner....run....");
    }
}
