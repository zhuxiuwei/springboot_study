package com.xiuwei.boot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("#76. 参数化测试")
public class ParameterTest {

    @ParameterizedTest
    @DisplayName("测试valueSource")
    @ValueSource(ints = {1,2,3,4,5})
    void valueSourceTest(int i){
        assertTrue(i < 6);
    }

    @ParameterizedTest
    @DisplayName("测试nullSource。提供一个null参数。")
    @NullSource()
    void nullSourceTest(String text){
        System.out.println(text);
        assertTrue(text == null);
    }

    @ParameterizedTest
    @DisplayName("测试emptySource。提供一个\"\"参数。")
    @EmptySource()
    @ValueSource(strings = { " ", "   ", "\t", "\n" })  //结合ValueSource，在""参数后，传入更多的参数。
    void emptySourceTest(String text){
        assertTrue(text.trim().length() == 0);
        /**
         * ✔️Test Results
             * ✔️#76. 参数化测试
             *      ✔️测试emptySource。提供一个""参数。
             *          ✔️[1] text=
             *          ✔️[2] text=
             *          ✔️[3] text=
             *          ✔️[4] text=
             *          ✔️[5] text=
         */
    }


    @ParameterizedTest
    @DisplayName("测试methodSource，参数从一个方法传过来")
    @MethodSource({"StringProvider"})   //方法名
    void methodSourceTest(String v){
        assertEquals(v.length(), 1);
    }
    static Stream<String> StringProvider(){     //1.必须是static  2.返回Stream，泛型要和测试方法的测试类型一致
        return Stream.of("a", "b", "c");
    }
}
