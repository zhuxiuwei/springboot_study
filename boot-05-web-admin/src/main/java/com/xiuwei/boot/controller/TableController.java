package com.xiuwei.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiuwei.boot.bean.User2;
import com.xiuwei.boot.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    //#68 删除用户
    @GetMapping("/user/delete/{id}")
    public String deleteUser2(@PathVariable("id") Long id,
                              @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                              RedirectAttributes redirectAttributes){
        user2Service.removeById(id);

        /**
         * 删除后，还要跳转到删除时所在的当前分页，而不是第一页。
         * 注意RedirectAttributes的使用，之前不了解。 会自动给redirect后面添加参数！
         */
        redirectAttributes.addAttribute("pn", pn);

        return "redirect:/dynamic_table";
    }
}
