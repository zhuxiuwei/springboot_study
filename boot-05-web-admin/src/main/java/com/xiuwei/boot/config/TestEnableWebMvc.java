package com.xiuwei.boot.config;

import com.xiuwei.boot.iterceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringMVC默认做了很多配置：https://docs.spring.io/spring-boot/docs/2.5.5/reference/html/features.html#features.developing-web-applications.spring-mvc.auto-configuration
 * 使用@EnableWebMvc标签后（慎用!），以上自动配置失效。 自己就全面接管SpringMVC配置 -- 所有的规则都需要自己重新配置。
 * 这里讲了一个例子，如何在使用@EnableWebMvc标签后，配置静态资源的映射行为。
 */
//@EnableWebMvc   //！！！！慎用！！！。不测试的时候我给注释掉了！！！！
//@Configuration    //不测试的时候我给注释掉了。
public class TestEnableWebMvc implements WebMvcConfigurer {

    //定义静态资源行为。配合开启"@EnableWebMvc "使用。
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 效果：访问/aa/下的所有请求，都去classpath:/static/下面进行匹配
         * 访问：http://localhost:8080/aa/css/bootstrap.min.css，会打开css文件；
         * 访问：http://localhost:8080/css/bootstrap.min.css，会返回404
         */
        registry.addResourceHandler("/aa/**")
                .addResourceLocations("classpath:/static/");
    }
}
