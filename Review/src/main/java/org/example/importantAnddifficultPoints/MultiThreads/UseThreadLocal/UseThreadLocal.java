package org.example.importantAnddifficultPoints.MultiThreads.UseThreadLocal;

/**
 * @Date: 2023/2/22
 * @Author: LTisme
 * @ClassName: UseThreadLocal
 * @Description: ---> 如果线程完全用不着修改主存变量，只是想用到它，那就可以用 ThreadLocal ，
 *                    请看下面，它就是将主存中的变量拷贝一份到线程独立的工作内存当中去
 */

public class UseThreadLocal {
    private static  int COUNT = 0;

    // 使用synchronized方法，只要有一段线程使用这段代码，那么另外一段线程就不能碰这段代码
    private synchronized static void adder(){
        COUNT++;
    }

    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                if (i % 1000 == 0){
                    System.out.println("t3 = 在作噢");
                }
                adder();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                if (i % 1000 == 0){
                    System.out.println("t4 = 在作噢");
                }
                adder();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("COUNT = " + COUNT);
        COUNT = 0;

        Thread t3 = new Thread(() -> {
            threadLocal.set(COUNT);
            for (int i = 0; i < 1000; i++) {
                threadLocal.set(threadLocal.get() + 1);
                System.out.println("t3 now is: " + threadLocal.get());
            }
        });

        Thread t4 = new Thread(() -> {
            threadLocal.set(COUNT);
            for (int i = 0; i < 1000; i++) {
                threadLocal.set(threadLocal.get() + 1);
                System.out.println("t4 now is: " + threadLocal.get());
            }
        });

        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("COUNT = " + COUNT);
    }
}
