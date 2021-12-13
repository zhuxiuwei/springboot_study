package com.xiuwei.booy.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 传参测试 #29 - #31
 */

@RestController
public class ParameterTestController2 /** implements WebMvcConfigurer */{

    /**
     * 矩阵变量测试
     * http://localhost:8080/cars/sell;low=34;brand=audi,bmw  打印：{"path":"sell","low":34,"brand":["audi","bmw"]}
     */
    @GetMapping("/cars/{path}")
    public Map<String, Object> matrixVariableTest(@MatrixVariable("low") Integer low,
                                                  @MatrixVariable("brand")List<String> brands,
                                                  @PathVariable("path") String path){
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brands);
        map.put("path", path);
        return map;
    }

    /**
     * 矩阵变量测试2 两个path variable，并且矩阵变量有重名。
     * http://localhost:8080/boss/1;age=12/3;age=5  打印：{"bossAge":12,"empAge":5}。 含义：id=1的boss age是12， id=3的emp age为5.
     */
    @GetMapping("/boss/{bossId}/{empId}")
    public Map<String, Object> matrixVariableTest(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                                                  @MatrixVariable(value = "age", pathVar = "empId") Integer empAge){
        Map<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        return map;
    }

    /**
     * Springboot默认禁用了矩阵变量功能（因为底层UrlPathHelper里，removeSemicolonContent属性默认为true，移除了分号内容）
     * 需要通过配置 UrlPathHelper 的 来使其生效。
     * 有两种方式，可以更新SpringMVC的UrlPathHelper配置
     */
//    方式1：我们手工往Spring容器中注入一个WebMvcConfigurer bean。这个bean配置了特殊的属性。
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                //不移除url里;后面的内容，矩阵变量就生效了。
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }
    //方式2：让controller 继承WebMvcConfigurer，并重写其中的方法
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        //不移除url里;后面的内容，矩阵变量就生效了。
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }
}
