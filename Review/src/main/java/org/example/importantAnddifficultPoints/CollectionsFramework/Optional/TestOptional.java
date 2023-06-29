package org.example.importantAnddifficultPoints.CollectionsFramework.Optional;

import org.testng.annotations.Test;

import java.util.Optional;

/**
 * @Date: 2023/3/14
 * @Author: LTisme
 * @ClassName: TestOptional
 * @Description: ---> 大概有4个常用方法：
 *                    ifPresent
 *                    orElse：如果包装对象值非空，返回包装对象值，否则返回入参other的值（默认值）。
 *                    orElseGet：与orElse()方法类似，区别在于orElseGet()方法的入参为一个Supplier对象，用Supplier对象的get()方法的返回值作为默认值。
 *                    orElseThrow：与orElseGet()方法非常相似了，入参都是Supplier对象，只不过orElseThrow()的Supplier对象必须返回一个Throwable异常。
 */

public class TestOptional{

    private static final Optional<String> optional = Optional.of("Default");

    @Test
    public void Test_ifPresent(){
        // 实现ifPresent中的Consumer接口即可
        optional.ifPresent(System.out::println);
    }

    @Test
    public void Test_orElse(){
        String s = optional.orElse("Val is null");
        System.out.println(s);
    }

    @Test
    public void Test_orElseGet(){
        String s = optional.orElseGet(() -> "Viva la vida");
        System.out.println(s);
    }

    @Test
    public void Test_orElseThrow(){
        String s = optional.orElseThrow(RuntimeException::new);
        System.out.println(s);
    }
}
