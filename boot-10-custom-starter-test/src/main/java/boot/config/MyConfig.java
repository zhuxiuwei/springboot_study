package boot.config;

import com.xiuwei.hello.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    /**
     * 测试自己生成bean并注册到容器，去替换starter生成的bean。
     * 不是必须的步骤。如果不自己生成，starter会生成（com.xiuwei.hello.auto.HelloServiceAutoConfiguration的@ConditionalOnMissingBean(HelloService.class)）
     */
    @Bean
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        System.out.println("用的是自己生成的HelloService，而不是xiuwei-hello-spring-boot-starter生成的HelloService！");
        return helloService;
    }

}
