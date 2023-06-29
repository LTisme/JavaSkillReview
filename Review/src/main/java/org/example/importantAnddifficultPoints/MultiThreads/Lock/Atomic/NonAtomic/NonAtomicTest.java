package org.example.importantAnddifficultPoints.MultiThreads.Lock.Atomic.NonAtomic;

/**
 * @Date: 2023/2/23
 * @Author: LTisme
 * @ClassName: AtomicTest
 * @Description: ---> 这里要说明 volatile 关键字不具备原子性，它不能代替 synchronized 关键字的原子性
 *                    为什么不能保证原子性呢？很简单，因为每个线程都不考虑别的线程的计算结果，
 *                    从主存中取数后只管在线程的独立空间中计算完成后刷到主存————也就是说线程之间不排队导致的问题
 */

public class NonAtomicTest {
    private static volatile int COUNT;

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            // Intellij注释已经说了，这是非原子操作
            new Thread(() -> {
//                ThreadUtils.sleep(10);
                COUNT++;
            }).start();
        }

        // 它加出来并不是500，如果不明显，可以让上面的每个线程都sleep上几十毫秒
        System.out.println("COUNT = " + COUNT);
    }
}
