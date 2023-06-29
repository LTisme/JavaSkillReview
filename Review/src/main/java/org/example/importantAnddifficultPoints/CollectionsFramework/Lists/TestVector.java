package org.example.importantAnddifficultPoints.CollectionsFramework.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * @Date: 2023/3/11
 * @Author: LTisme
 * @ClassName: TestVector
 * @Description: ---> Vector 是线性安全的 List 集合，它在所有方法上加了 synchronized 修饰，虽然安全但是很耗资源.
 *                    Vector是一种老的动态数组，是线程同步的，效率很低，一般不赞成使用。
 *                    同样线程安全但古老的还有Hashtable，简单粗暴，虽然安全但是很耗资源
 */

public class TestVector {
    private static final Integer Count = 200;

    public static void main(String[] args) throws InterruptedException {
//        final List<Integer> list = new Vector<>();
        // 如果用ArrayList，发现如下做法并不会让size = 200，而用Vector就好了
        final List<Integer> list = new ArrayList<>();
        // 这个类的作用和join一样，等待所有线程结束，才结束主线程
        CountDownLatch countDownLatch = new CountDownLatch(Count);
        for (int i = 0; i < Count; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                list.add(1);
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(list.size());
    }
}
