package org.example.importantAnddifficultPoints.MultiThreads.DeadLock;

import org.example.importantAnddifficultPoints.MultiThreads.ThreadUtils.ThreadUtils;

/**
 * @Date: 2023/2/22
 * @Author: LTisme
 * @ClassName: DeadLock
 * @Description: ---> 在这里复现死锁发生的情景
 */

public class DeadLock {
    // 这里采用Object当锁，Java所有的实例中，Object的实例占用的内存是最小的
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (LOCK1){
                System.out.println(Thread.currentThread().getName() + " 线程获取到了1号锁");
                ThreadUtils.sleep(100);
                synchronized (LOCK2){
                    System.out.println(Thread.currentThread().getName() + " 线程获取到了2号锁");
                }
            }
        }, "thread1").start();

        new Thread(() -> {
            synchronized (LOCK2){
                System.out.println(Thread.currentThread().getName() + " 线程获取到了2号锁");
                ThreadUtils.sleep(100);
                synchronized (LOCK1){
                    System.out.println(Thread.currentThread().getName() + " 线程获取到了1号锁");
                }
            }
        }, "thread2").start();
    }
}
