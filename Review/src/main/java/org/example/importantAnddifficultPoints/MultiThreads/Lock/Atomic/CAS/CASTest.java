package org.example.importantAnddifficultPoints.MultiThreads.Lock.Atomic.CAS;

/**
 * @Date: 2023/2/23
 * @Author: LTisme
 * @ClassName: CASTest
 * @Description: ---> 通过对 compare 方法使用 synchronized 关键字修饰来保证赋值的原子性。
 *                    底层CAS还是C语言写的，要保证CPU的原子性，这里其实还是伪CAS，因为它还是用同步方法来实现的
 */

public class CASTest {
    private static volatile int COUNT;

    private static synchronized boolean compare(int expect, int update){
        // 如果期望值仍然是我取数时候的值，那么我就对取数时的值进行修改
        if (expect == COUNT){
            COUNT = update;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        int length = 500;
        Thread[] thread_arr = new Thread[length];
        for (int i = 0; i < length; i++) {
            thread_arr[i] = new Thread(() -> {
                // 进行自旋，竞争不激烈时还可以，倘若有大量、激烈的竞争，就会产生大量的空转、自旋
                while (true){
                    boolean flag = compare(COUNT, COUNT+1);
                    if (flag) break;
                }
            });
        }

        for (int i = 0; i < length; i++) {
            thread_arr[i].start();
        }

        for (int i = 0; i < length; i++) {
            thread_arr[i].join();
        }

        System.out.println("COUNT = " + COUNT);
    }
}
