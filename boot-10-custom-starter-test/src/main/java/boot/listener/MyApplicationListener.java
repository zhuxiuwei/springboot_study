package boot.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * #86 原理解析-自定义事件监听组件
 * 自己实现一个ApplicationListener组件。
 */
public class MyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("MyApplicationListener....onApplicationEvent... ");
//        event.getTimestamp()      //针对event的各种操作。。。。
    }
}
