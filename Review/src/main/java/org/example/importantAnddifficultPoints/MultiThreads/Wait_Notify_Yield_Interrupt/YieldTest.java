package org.example.importantAnddifficultPoints.MultiThreads.Wait_Notify_Yield_Interrupt;

/**
 * @Date: 2023/2/23
 * @Author: LTisme
 * @ClassName: YieldTest
 * @Description: ---> yield 就是优先级屈服的意思，屈服不代表不执行，只是谦让别人，给别人机会多一些
 */

public class YieldTest {

    private static int COUNT1 = 0;
    private static int COUNT2 = 0;

    private static void add1(){
        System.out.println(Thread.currentThread().getName() + ": " + COUNT1++);
    }

    private static void add2(){
        System.out.println(Thread.currentThread().getName() + ": " + COUNT2++);
    }

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Thread.yield();
                add1();
            }
        }, "thread-1").start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                add2();
            }
        }, "thread-2").start();
    }
}
