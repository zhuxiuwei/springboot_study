package com.xiuwei.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 方案2： 在配置类MyConfig.java里，用@EnableConfigurationProperties(Car2.class)，1. 开启Car2配置绑定功能 2.把Car2自动注册到容器中。
 * 注意没有@Component”。 模拟当Car2是个第三方组件，我们没法添加@Component标签时。
 */
@ConfigurationProperties(prefix = "mycar")
public class Car2 {

    private String brand;
    private Integer price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car2{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}