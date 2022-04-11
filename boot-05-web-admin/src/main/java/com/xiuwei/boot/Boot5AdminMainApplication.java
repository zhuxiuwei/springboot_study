package com.xiuwei.boot;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类， 主配置类
 * @SpringBootApplication： 这是一个SpringBoot应用，等价于：
     @SpringBootConfiguration
     @EnableAutoConfiguration
     @ComponentScan("com.atguigu.boot")
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.xiuwei.boot.servlet")   //用于扫描自定义的servlet。我的例子：com.xiuwei.boot.servlet.MyServlet
//@MapperScan("com.xiuwei.boot.mapper")   //如果用这个，就不用给每个mapper类加@Mapper注解了。
public class Boot5AdminMainApplication {
    public static void main(String[] args) {
        //返回的也是个ApplicationContext
        ConfigurableApplicationContext run = SpringApplication.run(Boot5AdminMainApplication.class, args);
    }
}