package com.xiuwei.boot.config;

import com.xiuwei.boot.iterceptor.LoginInterceptor;
import com.xiuwei.boot.iterceptor.RedisUrlCounterInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * 讲编写的拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 * 制订拦截规则（如果拦截所有，静态资源也被拦截）
 */
@Configuration  //！！！！注意不要忘了！！！！！
public class AdminWebConfig implements WebMvcConfigurer {

    @Autowired
    RedisUrlCounterInterceptor redisUrlCounterInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")     //拦截所有请求，包括静态资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");  //放行静态资源

        registry.addInterceptor(redisUrlCounterInterceptor) //不能直接new RedisUrlCounterInterceptor，这样不能被容器托管，RedisUrlCounterInterceptor里通过autowired注入的类就不生效了。
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");  //放行静态资源
    }
}
