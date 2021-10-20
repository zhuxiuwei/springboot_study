package com.xiuwei.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 宠物
 */
@ToString
@Data
@NoArgsConstructor  //无参构造器
public class Pet {

    private String name;

    public Pet(String name) {
        this.name = name;
    }
}