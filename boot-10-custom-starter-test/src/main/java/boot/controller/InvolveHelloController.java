package boot.controller;

import com.xiuwei.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试我自己的hello starter（boot-10-custom-starter）。
 */
@RestController
public class InvolveHelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("hello")
    public String sayHello(){
        String hello = helloService.sayHello("张三");
        return hello;
    }

}
