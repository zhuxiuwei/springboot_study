package com.xiuwei.boot.config;

import com.xiuwei.boot.iterceptor.LoginInterceptor;
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
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")     //拦截所有请求，包括静态资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");  //放行静态资源
    }
}
