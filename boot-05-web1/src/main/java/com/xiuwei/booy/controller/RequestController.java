package com.xiuwei.booy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//#30 测试@RequestAttribute获取Request域保存的数据
@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg", "成功");
        request.setAttribute("code", 200);
        return "forward:/success";  //转发到 /success请求。
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(@RequestAttribute("msg") String message,  //通过注解获取Request域保存的数据
                                       @RequestAttribute("code") String code,
                                       HttpServletRequest request){ //也可以通过HttpServletRequest，获取Request域保存的数据
        Map<String, Object> map = new HashMap<>();
        map.put("requestParameter msg", request.getAttribute("msg"));
        map.put("@RequestAttribute annotation msg", message);
        return map;
    }

    /**
     * 测试： http://localhost:8080/goto
     * 浏览器打印： {"@RequestAttribute annotation msg":"成功","requestParameter msg":"成功"}
     */

}
