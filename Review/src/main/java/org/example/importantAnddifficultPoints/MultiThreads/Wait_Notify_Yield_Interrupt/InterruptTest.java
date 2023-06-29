package org.example.importantAnddifficultPoints.MultiThreads.Wait_Notify_Yield_Interrupt;

import org.example.importantAnddifficultPoints.MultiThreads.ThreadUtils.ThreadUtils;

/**
 * @Date: 2023/2/23
 * @Author: LTisme
 * @ClassName: InterruptTest
 * @Description: ---> 只有线程是处于 sleep 或者 wait 的阻塞状态下，才能被打断，正常的运行逻辑是无法被打断的
 */

public class InterruptTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("begin");
            try {
                Thread.sleep(999999999);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end");
        }, "thread-1");

        t1.start();
        ThreadUtils.sleep(200);
        System.out.println("main-thread begins to interrupt thread-1...");
        t1.interrupt();
    }
}
