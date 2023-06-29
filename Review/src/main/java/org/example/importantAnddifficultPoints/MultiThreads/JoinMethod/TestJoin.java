package org.example.importantAnddifficultPoints.MultiThreads.JoinMethod;

import org.example.importantAnddifficultPoints.MultiThreads.ThreadUtils.ThreadUtils;

/**
 * @Date: 2023/2/20
 * @Author: LTisme
 * @ClassName: TestJoin
 * @Description: ---> 线程实例调用join方法，就会阻塞主线程————当在某个程序执行流中调用其他线程的
 *                    join()方法时，调用线程将被阻塞，直到被join()方法加入的join线程执行完为止。
 */

public class TestJoin {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            ThreadUtils.sleep(2000);
            System.out.println("t1---------");
        });
        Thread t2 = new Thread(() -> {
            ThreadUtils.sleep(1000);
            System.out.println("t2---------");
        });

        t1.start();
        t2.start();

        // 下面是让主线程启动了t1、t2线程后，让主线程等待t1线程执行结束再回来继续
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main thread ---------------------");
    }
}
