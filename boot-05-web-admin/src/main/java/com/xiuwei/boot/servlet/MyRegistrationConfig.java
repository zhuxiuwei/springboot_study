package com.xiuwei.boot.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Configuration
public class MyRegistrationConfig {

    //注册servlet到Spring boot
    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet2 servlet2 = new MyServlet2();
        return new ServletRegistrationBean(servlet2, "/servletTest2", "/servletTest22");
    }

    //注册filter到Spring boot
    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter2 filter2 = new MyFilter2();

        //写法1：用setUrlPatterns定义拦截路径
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(filter2);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/css/*", "/images/*"));
        return filterRegistrationBean;

        //写法2：拦截myServlet bean里定义的路径，即"servletTest2", "servletTest22"
        // return new FilterRegistrationBean(filter2, myServlet());
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();
        bean.setListener(new MyListener2());
        return bean;
    }

}

//原生servlet
class MyServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("MyServlet2!!!");
    }
}

//原生filter
@Slf4j
class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter2初始化完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("MyFilter2工作");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("MyFilter2销毁");
    }
}

//原生listener
@Slf4j
class MyListener2 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("MyListener2监听到项目初始化完成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("MyListener2监听到项目销毁完成");

    }
}