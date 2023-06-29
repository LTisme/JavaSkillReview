package org.example.importantAnddifficultPoints.MultiThreads.JUCPackage.ThreadPool;

import org.example.importantAnddifficultPoints.MultiThreads.ThreadUtils.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date: 2023/2/24
 * @Author: LTisme
 * @ClassName: newFixedThreadPoolTest
 * @Description: --->
 */

public class newFixedThreadPoolTest {

    private static final ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        Runnable task = () -> {
            ThreadUtils.sleep(200);
            System.out.println(Thread.currentThread().getName() + "---------");
        };
        // 让后给线程池提交任务就行
        for (int i = 0; i < 10; i++) {
            pool.submit(task);
        }
        // 线程池启动起来不会自己关闭，需调用关闭方法
        pool.shutdown();
    }
}
