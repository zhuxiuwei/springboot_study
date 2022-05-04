package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 用于测试自定义starter:xiuwei-hello-spring-boot-starter (boot-10-custom-starter下)
 * 注意本测试类和boot-10-custom-starter是一个工程下的不同module.
 * 正常情况下，需要把boot-10-custom-starter安装到一个maven仓库（如本地仓库），test工程再引入依赖。
 * 因为本module和boot-10-custom-starter是一个工程下的不同module，就不需要boot-10-custom-starter再单独打包上传到maven库了
 * 本module的pom里直接引入boot-10-custom-starter的依赖即可。
 */
@SpringBootApplication
public class Boot10StarterTestMainApplication {
    public static void main(String[] args) {
         ConfigurableApplicationContext run = SpringApplication.run(Boot10StarterTestMainApplication.class, args);
    }
}