package com.xiuwei.boot;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DisplayName("#73. Junit5断言使用测试")
public class Junit5TestAssertions {

    //断言时，前面的断言如果失败，后面的代码都不会执行了。
    @Test
    @DisplayName("测试简单断言")
    void testSimpleAssertion(){
        //相等
        assertEquals(22, 1 + 21, "这是可选的错误提示。");

        //两个对象是否同一个
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertNotSame(obj1, obj2);
    }

    @Test
    @DisplayName("数组 assertion")
    public void array() {
        assertArrayEquals(new int[]{1, 2}, new int[] {2, 1}, "数组内容不相等！");
        //org.opentest4j.AssertionFailedError: 数组内容不相等！ ==> array contents differ at index [0], expected: <1> but was: <2>
    }

    @Test
    @DisplayName("组合断言，必须所有断言都成功才成功")
    public void all() {
        assertAll("test",
                () -> assertTrue(1 == 1, "结果不是true"),
                () -> assertEquals("haha", "haha", "结果不相等"));
    }

    @Test
    @DisplayName("异常断言，抛出期望的异常才ok")
    public void exception() {
        String obj = null;
        assertThrows(NullPointerException.class,
                () -> obj.equals(""), "居然没有抛异常！" );
    }

    @Test
    @DisplayName("超时断言，如果执行时间超时了就抛异常")
    public void timeout() {
        assertTimeout(Duration.ofMillis(200), () -> f());   //写法1
//        assertTimeout(Duration.ofMillis(200), () -> Thread.sleep(400));   //写法2
        //org.opentest4j.AssertionFailedError: execution exceeded timeout of 200 ms by 201 ms
    }
    void f() throws InterruptedException {
        Thread.sleep(400);
    }

    @Test
    @DisplayName("直接失败测试")
    public void failTest() {
        //bala bala一堆逻辑....
       fail("到这里直接失败吧。");
       //org.opentest4j.AssertionFailedError: 到这里直接失败吧。
    }
}
