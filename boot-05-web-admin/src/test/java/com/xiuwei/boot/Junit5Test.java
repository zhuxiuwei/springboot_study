package com.xiuwei.boot;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest //本注解包含了@ExtendWith({SpringExtension.class}    -- extendWith，类似老版本的runWith。加了这个，这个测试类就能用Spring的功能了，如Autowire
@DisplayName("#72. Junit5功能测试")
public class Junit5Test {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @DisplayName("测试修改DisplayName")
    @Test
    void testDisplayName(){
        System.out.println("效果：测试结果里类名、方法名被替换为DisplayName标记的。如下：");
        /**
         * 左边的测试报告显示：
         * ✔️ Test Results
         *  ✔️ Junit5功能测试
         *      ✔️ 测试修改DisplayName
         */
    }

    @Disabled   //禁用测试
    @Test
    void testDisabled(){
        System.out.println("test2");
    }

    @Test
    void testExtendWith(){
        //加了@SpringBootTest（相当于也加了@ExtendWith），则能打印出来这个类。否则打印null。
        System.out.println(stringRedisTemplate);    //打印：org.springframework.data.redis.core.StringRedisTemplate@194012a2
    }

    @Timeout(value=1, unit= TimeUnit.SECONDS)   //规定超时时间
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(1500);
        /**
         * java.util.concurrent.TimeoutException: testTimeout() timed out after 1 second
            ......
         * 	Suppressed: java.lang.InterruptedException: sleep interrupted
         * 		at java.lang.Thread.sleep(Native Method)
            ......
         */
    }

    @Test
    @RepeatedTest(value = 2, name = "哈哈")
    void repeatTest(){
        System.out.println("重复测试...");
        /**
         * 左边的测试报告显示：
         * ✔️ Test Results
         *      ✔️ Junit5功能测试
         *      ✔️ repeatTest()
         *      ✔️ repeatTest()
         *          ✔️ 哈哈
         *          ✔️ 哈哈
         */
    }

    @DisplayName("#74 测试前置条件")
    @Test
    void testAssumptions(){
        Assumptions.assumeTrue(2 == 1, "结果不是true!");
        System.out.println(111);
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试要开始了！");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束了！");
    }

    @BeforeAll
    static void testBeforeAll(){    //必须是static方法
        System.out.println("所有测试要开始了！");
    }

    @AfterAll
    static void testAfterAll(){     //必须是static方法
        System.out.println("所有测试结束了！");
    }
}
