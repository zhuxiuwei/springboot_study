package boot.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * #86 原理解析-自定义事件监听组件
 * 自己实现一个SpringApplicationRunListener组件。
 */
public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    private SpringApplication application;

    public MySpringApplicationRunListener(SpringApplication application, String[] args){
        this.application = application;     //可以在各种方法里操作application
    }
    /*  必须有这个构造器，否则MainApp启动报错：
    Exception in thread "main" java.lang.IllegalArgumentException: Cannot instantiate interface org.springframework.boot.SpringApplicationRunListener : boot.listener.MySpringApplicationRunListener
	at org.springframework.boot.SpringApplication.createSpringFactoriesInstances(SpringApplication.java:475)
	at org.springframework.boot.SpringApplication.getSpringFactoriesInstances(SpringApplication.java:457)
	at org.springframework.boot.SpringApplication.getRunListeners(SpringApplication.java:445)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:328)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1343)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1332)
	at boot.Boot10StarterTestMainApplication.main(Boot10StarterTestMainApplication.java:17)
Caused by: java.lang.NoSuchMethodException: boot.listener.MySpringApplicationRunListener.<init>(org.springframework.boot.SpringApplication, [Ljava.lang.String;)
	at java.lang.Class.getConstructor0(Class.java:3082)
	at java.lang.Class.getDeclaredConstructor(Class.java:2178)
	at org.springframework.boot.SpringApplication.createSpringFactoriesInstances(SpringApplication.java:470)
	... 6 more
     */

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("MySpringApplicationRunListener....starting...");
//        application.setXXX        //操作application。。。。
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("MySpringApplicationRunListener....environmentPrepared...");
    }


    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener....contextPrepared...");
        //context的各种操作。。。。。
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener....contextLoaded...");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener....started...");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener....running...");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("MySpringApplicationRunListener....failed..");
    }
}
