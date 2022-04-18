package com.xiuwei.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableController {


    @GetMapping("/basic_table")
    public String basicTable(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamicTable(){
        /** #63 mybatis-plus - 从Mysql user表中查数据。 */


        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsiveTable(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editableTable(){
        return "table/editable_table";
    }
}
