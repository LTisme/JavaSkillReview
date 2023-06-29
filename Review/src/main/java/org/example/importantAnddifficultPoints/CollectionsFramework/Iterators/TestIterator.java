package org.example.importantAnddifficultPoints.CollectionsFramework.Iterators;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Date: 2023/3/9
 * @Author: LTisme
 * @ClassName: TestIterator
 * @Description: ---> 这个要比forEach简单，但是注意，Iterable接口只有Collections集合才有，Map是没有的
 *                    但是Map的KeySet是Collections集合，可以通过迭代key集合，所以先去获得keySet()就好了
 *                    for循环中删除有点坑的，有几种解决办法：
 *                    第一种：每次删除后需要回调一下指针
 *                    第二种：从尾部开始删除
 *                    第三种：也是最推荐的，就算使用迭代器删除元素，注意的是调用的删除方法得是迭代器的删除方法
 */

public class TestIterator {

    public static void main(String[] args) {
        var books = new HashSet<>();
        books.add("book1");
        books.add("book2");
        books.add("book3");
        books.add("book4");

        Iterator<Object> iterator = books.iterator();
        while (iterator.hasNext()){
            System.out.println("val is " + iterator.next());
        }

        // 当然还有增强for循环，也就是语法糖，这个就更简单了，Python也非常贴合这种写法
        for (var obj :
                books) {
            System.out.println("val is " + obj);
        }
    }
}
