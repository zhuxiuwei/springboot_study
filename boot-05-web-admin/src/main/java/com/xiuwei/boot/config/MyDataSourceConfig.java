package com.xiuwei.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * #61 自定义配置druid数据源
 */
@Configuration
public class MyDataSourceConfig {

    //自定义
    @Bean
    @ConfigurationProperties("spring.datasource")   //！！！！注意标签。可以自动从application.properties读取配置数据，去装配DataSource这个Bean的属性！！！
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();

        //因为有 @ConfigurationProperties注解，下面代码可以省略了。
//        druidDataSource.setUrl();
//        druidDataSource.setUsername();
//        druidDataSource.setPassword();
//        druidDataSource.setDriverClassName();
        return druidDataSource;
    }

}
