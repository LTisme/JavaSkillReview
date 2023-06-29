package org.example.importantAnddifficultPoints.MultiThreads.Wait_Notify_Yield_Interrupt;

import org.example.importantAnddifficultPoints.MultiThreads.ThreadUtils.ThreadUtils;

/**
 * @Date: 2023/2/23
 * @Author: LTisme
 * @ClassName: WaitTest
 * @Description: ---> notify 让系统随机唤醒一个线程；
 *                    notifyAll() 让系统唤醒全部线程，让它们竞争
 *
 *                    wait 和 sleep 的区别是，wait 会释放锁，而 sleep 不会，但是它们都会释放 CPU 的资源
 */

public class WaitTest {

    // 先建立一把锁
    public static final Object MONITOR = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (MONITOR){
                System.out.println(Thread.currentThread().getName() + " started!");
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " is over.");
            }
        }, "thread1").start();

        new Thread(() -> {
            synchronized (MONITOR){
                System.out.println(Thread.currentThread().getName() + " started!");
                ThreadUtils.sleep(200);
                MONITOR.notify();
                System.out.println(Thread.currentThread().getName() + " is over.");
            }
        }, "thread2").start();
    }
}
