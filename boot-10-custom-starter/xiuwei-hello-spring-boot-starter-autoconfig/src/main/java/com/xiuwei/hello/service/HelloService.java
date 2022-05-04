package com.xiuwei.hello.service;

import com.xiuwei.hello.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 1. starter要包含的逻辑。sayHello。其中，prefix, suffix要从配置文件读取。
 * 2. 默认不要放在容器中。
 */
public class HelloService {

    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String userName){
        return helloProperties.getPrefix() + ": " + userName + "》" + helloProperties.getSuffix();
    }
}
