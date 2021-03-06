package com.xiuwei.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

//#63 mybatis-plus CRUD用的测试类
@Data
@TableName("user2")    //默认会找和bean同名的表，若table名和bean名不一样，用@TableName标签指定表名 。
public class User2 {
    private Long id;
    private String name;
    private Integer age;
    private String email;

    //#63 演示@TableField标签屏蔽CRUD时的db中不存在的列。
    //不加这个标签，selectById会报错：### Error querying database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column 'foo' in 'field list'
    @TableField(exist = false)
    private String foo;
}