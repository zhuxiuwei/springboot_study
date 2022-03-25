package com.xiuwei.boot.controller;

import com.xiuwei.boot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.rmi.MarshalledObject;

@Controller
public class IndexController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 来登录页
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage(){
        return "login";
    }

    //登录去主页
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        //判断账号密码
        if(!StringUtils.isEmpty(user.getUserName()) && !StringUtils.isEmpty(user.getPassword())){
            //把登录成功的用户保存到Session
            session.setAttribute("loginUser", user);
            //登录成功，重定向到main页面。用重定向，避免表单重复提交。
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg", "账号密码错误!");
            //回退到登录页
            return "login";
        }

    }

    //去main页面
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model){

        //是否登录。
        //TODO: 后续改成拦截器、过滤器
        if(session.getAttribute("loginUser") != null){
            return "main";
        }
        else {
            model.addAttribute("msg", "请登录!");
            return "login";
        }

    }

    //随便执行一个sql。用于数据库测试。
    @ResponseBody
    @GetMapping("/sql")
    public String testSql(){
        System.out.println(1111);
        Long aLong = jdbcTemplate.queryForObject("select count(*) from tbl_employee", Long.class);
        return aLong + "";
    }

}
