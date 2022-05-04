package com.xiuwei.boot;
import com.xiuwei.boot.bean.Color;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

/**
 * 主程序类， 主配置类
 */
@SpringBootApplication
@PropertySource(value = "classpath:application.properties",encoding = "UTF-8")
public class MainApplication {
    public static void main(String[] args) {
        //返回的也是个ApplicationContext
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);


        /**
         * #81. 测试com.xiuwei.boot.config.MyConfig里，@Profile标记在方法上。
         */
        try{
            Color color = run.getBean("red", Color.class);
            System.out.println("red Color已注册！" + color);
        }catch (Exception e){
            System.out.println("name=red的Color类没有注册。");
        }
        try{
            Color color = run.getBean("green", Color.class);
            System.out.println("green Color已注册！" + color);
        }catch (Exception e){
            System.out.println("name=green的Color类没有注册。");
        }

    }
}