package org.example.importantAnddifficultPoints.MultiThreads.LockSupport;

import org.example.importantAnddifficultPoints.MultiThreads.ThreadUtils.ThreadUtils;

import java.util.concurrent.locks.LockSupport;

/**
 * @Date: 2023/2/23
 * @Author: LTisme
 * @ClassName: LockSupportTest
 * @Description: ---> LockSupport是一个线程阻塞工具类，所有的方法都是静态方法，可以让线程在任意位置阻塞，当然阻塞之后肯定得有唤醒的方法。
 *                   主要有两类方法 park() 和 unpark()
 */

public class LockSupportTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(1);
            ThreadUtils.sleep(1000);
            System.out.println(2);
            // 让线程阻塞
            LockSupport.park();
            System.out.println(3);
        });
        t1.start();

        System.out.println("main-thread starts sleeping...");
        ThreadUtils.sleep(2000);
        System.out.println("Sleep completed.");
        // 唤醒指定线程
        LockSupport.unpark(t1);
    }
}
