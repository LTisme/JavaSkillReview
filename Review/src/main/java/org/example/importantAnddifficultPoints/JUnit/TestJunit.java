package org.example.importantAnddifficultPoints.JUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @Date: 2023/3/13
 * @Author: LTisme
 * @ClassName: TestJunit
 * @Description: ---> 这里会测试 JUnit 断言、注解
 */

public class TestJunit {
    @Test
    public void Test1(){
        System.out.println("Hello junit!");
    }

    @Test
    public void Test2(){
        System.out.println(1/0);
    }

    /** 断言
     * Junit所有的断言都包含在 Assert 类中。
     * 这个类提供了很多有用的断言方法来编写测试用例。只有失败的断言才会被记录。Assert 类中的一些有用的方法列式如下：

     * void assertEquals(boolean expected, boolean actual):检查两个变量或者等式是否平衡
     * void assertTrue(boolean expected, boolean actual):检查条件为真
     * void assertFalse(boolean condition):检查条件为假
     * void assertNotNull(Object object):检查对象不为空
     * void assertNull(Object object):检查对象为空
     * void assertSame(boolean condition):assertSame() 方法检查两个相关对象是否指向同一个对象
     * void assertNotSame(boolean condition):assertNotSame() 方法检查两个相关对象是否不指向同一个对象
     * void assertArrayEquals(expectedArray, resultArray):assertArrayEquals() 方法检查两个数组是否相等
     */
    @Test
    public void Test3(){
        int i = 5;
        i++;
        Assert.assertEquals(i,6);
    }

    /** 注解
     * @Test:这个注释说明依附在 JUnit 的 public void 方法可以作为一个测试案例。
     * @Before:有些测试在运行前需要创造几个相似的对象。在 public void 方法加该注释是因为该方法需要在 test 方法前运行。
     * @After:如果你将外部资源在 Before 方法中分配，那么你需要在测试运行后释放他们。在 public void 方法加该注释是因为该方法需要在 test 方法后运行。
     */
    @BeforeTest
    public void before(){
        System.out.println("Before Testing……");
    }

    @BeforeTest
    public void before2(){
        System.out.println("Before2 Testing……");
    }

    @AfterTest
    public void after(){
        System.out.println("After Test……");
    }

    @Test
    public void doTest(){
        System.out.println("Now is Testing……");
    }
}
