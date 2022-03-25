package com.xiuwei.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * #61 自定义配置druid数据源
 */
@Configuration
public class MyDataSourceConfig {

    //自定义
    @Bean
    @ConfigurationProperties("spring.datasource")   //！！！！注意标签。可以自动从application.properties读取配置数据，去装配DataSource这个Bean的属性！！！
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();

        //因为有 @ConfigurationProperties注解，下面代码可以省略了。
//        druidDataSource.setUrl();
//        druidDataSource.setUsername();
//        druidDataSource.setPassword();
//        druidDataSource.setDriverClassName();
        /**
         * 开启druid监控统计，执行sql后访问http://localhost:8080/druid/sql.html可以看执行sql统计信息。
         * 官网：https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_StatFilter
         */
        druidDataSource.setFilters("stat");
        return druidDataSource;
    }

    /**
     * 配置druid的监控页
     * 测试： 访问http://localhost:8080/druid可以工作。
     * 官网：https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_StatViewServlet%E9%85%8D%E7%BD%AE
     */
    @Bean
    public ServletRegistrationBean dsda(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean res = new ServletRegistrationBean(statViewServlet, "/druid/*");
        return res;
    }

}
