package org.example.importantAnddifficultPoints.JUnit;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Date: 2023/3/13
 * @Author: LTisme
 * @ClassName: TestArrayListAndLinkedList
 * @Description: ---> 对比 ArrayList 和 LinkedList ，结论：
 *                    只有在头插数据、随机删除数据的情况下，LinkedList 具有明显优势之外，ArrayList 一直都更加快，所以工作中基本上 80% 都是用 ArrayList
 */

public class TestArrayListAndLinkedList {

    // ----------------尾插法
    @Test
    public void testArrayListAdd(){
        List<Integer> list = new ArrayList<>();
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add((int)(Math.random()*100));
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
    }
//    结果：
//    用时243毫秒。

    @Test
    public void testLinkedListAdd(){
        List<Integer> list = new LinkedList<>();
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add((int)(Math.random()*100));
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
    }
//    结果：
//    用时2524毫秒。

    // ----------------头插法

    @Test
    public void testArrayListAddHeader(){
        List<Integer> list = new ArrayList<>();
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(0,(int)(Math.random()*100));
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
    }
//    结果：
//    无法算出，太慢

    @Test
    public void testLinkedListAddHeader(){
        List<Integer> list = new LinkedList<>();
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(0,(int)(Math.random()*100));
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
    }
//    结果：
//    用时2487毫秒。

    // 使用for循环迭代获取
    @Test
    public void testArrayListFor(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add((int)(Math.random()*100));
        }
        System.out.println("开始------");
        Long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
    }
//    结果：
//    用时2毫秒。

    @Test
    public void testLinkedListFor(){
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add((int)(Math.random()*100));
        }
        System.out.println("开始------");
        Long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
    }
//    结果：
//    无法计算时间。


    // --------------用迭代器迭代结果
    @Test
    public void testArrayListIterator(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add((int)(Math.random()*100));
        }
        System.out.println("开始------");
        Long start = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
    }
//    结果：
//    开始------
//    用时4毫秒。

    @Test
    public void testLinkedListIterator(){
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add((int)(Math.random()*100));
        }
        System.out.println("开始------");
        Long start = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
    }

//    结果：
//    开始------
//    用时42毫秒。

    // -----随机删除
    @Test
    public void testArrayListDel(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(0,(int)(Math.random()*100));
        }
        Long start = System.currentTimeMillis();
        // 不用管为啥，这就是排序，复制过来用就行，写个冒泡也行
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next()>5000000){
                iterator.remove();
            }
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
    }
//        结果：
//    太慢，时间没出来

    @Test
    public void testLinkedListDel(){
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(0,(int)(Math.random()*100));
        }
        Long start = System.currentTimeMillis();
        // 不用管为啥，这就是排序，复制过来用就行，写个冒泡也行
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next()>5000000){
                iterator.remove();
            }
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
    }
//    结果：
//    用时45毫秒。

}
