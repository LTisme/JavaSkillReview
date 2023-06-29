package org.example.importantAnddifficultPoints.MultiThreads.JUCPackage.ThreadSynchronization.Semaphore;

import org.example.importantAnddifficultPoints.MultiThreads.ThreadUtils.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Date: 2023/2/25
 * @Author: LTisme
 * @ClassName: SemaphoreTest
 * @Description: ---> 信号量，就是令牌桶，每次执行都需要去令牌桶里取令牌，只有有令牌的线程才能执行
 *                    它和锁很像，但是锁只能被一个线程持有，但是semaphore它有数量，只要数量不超出，这些线程都能执行
 */

public class SemaphoreTest {

    private static final Semaphore semaphore = new Semaphore(5);

    //
    private static final ExecutorService pool = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            final int x = i;
            Runnable runnable = () -> {
                try {
                    // 获取许可
                    semaphore.acquire();
                    // lambda表达式或者匿名内部类不能访问非final的局部变量，所以不能直接使用i放进去
                    System.out.println("开进一辆车……编号为：" + x);
                    ThreadUtils.sleep((long)(Math.random()* 1000));
                    // 处理完毕，释放
                    semaphore.release();
                    System.out.println("离开一辆车……" + x);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            pool.submit(runnable);
        }
        pool.shutdown();
    }
}
