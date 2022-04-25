package com.xiuwei.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiuwei.boot.bean.User2;
import com.xiuwei.boot.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TableController {

    @Autowired
    User2Service user2Service;

    @GetMapping("/basic_table")
    public String basicTable(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamicTable(@RequestParam(value = "pn", defaultValue = "1") Integer pn,  Model model){
        /** #63 mybatis-plus - 从Mysql user表中查数据。 */

        //List<User2> list = user2Service.list();       //查全部 无分页
        //model.addAttribute("users", list);

        //分页查
        int pageSize = 2;   //每页数量
        Page<User2> user2Page = new Page<>(pn ,pageSize);
        Page<User2> page = user2Service.page(user2Page, null);
        model.addAttribute("page", page);
        model.addAttribute("users", page.getRecords());

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsiveTable(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_ table")
    public String editableTable(){
        return "table/editable_table";
    }
}
