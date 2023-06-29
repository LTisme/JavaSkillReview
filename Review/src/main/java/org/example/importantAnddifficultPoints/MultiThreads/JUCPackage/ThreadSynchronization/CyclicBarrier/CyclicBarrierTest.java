package org.example.importantAnddifficultPoints.MultiThreads.JUCPackage.ThreadSynchronization.CyclicBarrier;

import org.example.importantAnddifficultPoints.MultiThreads.ThreadUtils.ThreadUtils;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date: 2023/2/25
 * @Author: LTisme
 * @ClassName: CyclicBarrierTest
 * @Description: --->
 */

public class CyclicBarrierTest {

    private static ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {

        // 计算总账的主线程
        Runnable main = () -> System.out.println("计算总账！");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,main);

        Runnable task1 = () -> {
            ThreadUtils.sleep(new Random().nextInt(5000));
            System.out.println("计算山西分公司的账目");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
        Runnable task2 = () -> {
            ThreadUtils.sleep(new Random().nextInt(5000));
            System.out.println("计算北京分公司的账目");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
        Runnable task3 = () -> {
            ThreadUtils.sleep(new Random().nextInt(5000));
            System.out.println("计算上海分公司的账目");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
        pool.submit(task1);
        pool.submit(task2);
        pool.submit(task3);

        // 使用reset()方法，进行重复利用
        ThreadUtils.sleep(5000);
        cyclicBarrier.reset();
        System.out.println("-------------reset-----------");
        pool.submit(task1);
        pool.submit(task2);
        pool.submit(task3);
    }
}
