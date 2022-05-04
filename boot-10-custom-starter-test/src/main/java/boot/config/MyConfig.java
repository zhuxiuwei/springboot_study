package boot.config;

import com.xiuwei.hello.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    /**
     * 测试自己生成bean并注册到容器，去替换starter生成的bean。
     */
    @Bean
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        System.out.println("用的是自己生成的HelloService，而不是xiuwei-hello-spring-boot-starter生成的HelloService！");
        return helloService;
    }

}
