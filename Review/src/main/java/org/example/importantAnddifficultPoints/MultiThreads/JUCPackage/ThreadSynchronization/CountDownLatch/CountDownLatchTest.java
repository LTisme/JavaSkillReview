package org.example.importantAnddifficultPoints.MultiThreads.JUCPackage.ThreadSynchronization.CountDownLatch;

import org.example.importantAnddifficultPoints.MultiThreads.ThreadUtils.ThreadUtils;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date: 2023/2/25
 * @Author: LTisme
 * @ClassName: CountDownLatchTest
 * @Description: ---> 下面的逻辑用 join 方法也可以实现，说它优雅嘛，我并不觉得
 */

public class CountDownLatchTest {
    private static ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Runnable task1 = () -> {
            ThreadUtils.sleep(new Random().nextInt(2000));
            System.out.println("计算山西分公司的账目");
            countDownLatch.countDown();
        };
        Runnable task2 = () -> {
            ThreadUtils.sleep(new Random().nextInt(2000));
            System.out.println("计算北京分公司的账目");
            countDownLatch.countDown();
        };
        Runnable task3 = () -> {
            ThreadUtils.sleep(new Random().nextInt(2000));
            System.out.println("计算上海分公司的账目");
            countDownLatch.countDown();
        };
        pool.submit(task1);
        pool.submit(task2);
        pool.submit(task3);
        countDownLatch.await();
        pool.shutdown();

        System.out.println("计算总账！");
    }
}
