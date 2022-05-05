package boot.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * #86 原理解析-自定义事件监听组件 - 自己实现一个CommandLineRunner组件。
 * 使用场景：应用启动做一个一次性事情。
 */
@Component
@Order(1)   //可以定义启动顺序，数字小的优先极高先启动
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner....run....");
    }
}