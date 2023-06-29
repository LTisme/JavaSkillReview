package org.example.importantAnddifficultPoints.MultiThreads.JUCPackage.ThreadPool.CustomizedThreadPool;

import java.util.concurrent.*;

/**
 * @Date: 2023/2/25
 * @Author: LTisme
 * @ClassName: CustomizedThreadPoolTest
 * @Description: ---> 自定义线程池一般是香不过那些已经写好的线程池实现类，但是在大量的线程处理环境下，仍然有出现OOM的可能，
 *                    比如newFixedThreadPool允许的请求队列长度为Integer.MAX_VALUE，可能会堆积大量请求；
 *                    newCachedThreadPool允许创建的线程数量为Integer.MAX_VALUE，可能会创建大量线程；（阿里巴巴规约）
 *                    所以那些大厂就会去自定义一些线程，主要是在核心线程数量，最大线程数量，任务队列上限上作限制。
 *                    可以通过抄写JUC包下已有的线程池，作修改来实现自定义线程池
 */

public class CustomizedThreadPoolTest {
    private static ExecutorService executorService = new ThreadPoolExecutor(
            5,                                      // 核心线程数，这是经验型数字，要根据对电脑的熟悉程度设置
            10,                                                // 最大线程数，这是经验型数字，要根据对电脑的熟悉程度设置
            60L,                                               // 空闲线程最长可存活时间
            TimeUnit.MILLISECONDS,                             // 时间单位，配合空闲线程最长可存活时间
            new ArrayBlockingQueue<>(50),              // 链表任务队列长度是无限的，可以用有界的ArrayBlockingQueue来替代
//            Executors.defaultThreadFactory(),                // 线程工厂，一般来说，它的作用就只是创建线程，
            Thread::new,                                       // 这里就简单用lambda表达式来表示线程工厂
//            new ThreadPoolExecutor.AbortPolicy()               // 拒绝策略，如果该线程无法执行或不适合执行当前任务，如何抛出异常的策略
            (runnable, executor) -> System.out.println("这个任务无法处理，已被抛弃")
            );

    public static void main(String[] args) {
        for (int i = 0; i < 600; i++) {
            executorService.submit(new Thread(() -> System.out.println("------")));
        }
        // 线程池记得要关闭
        executorService.shutdown();
    }
}
