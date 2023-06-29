package org.example.importantAnddifficultPoints.MultiThreads.UseSynchronized;

/**
 * @Date: 2023/2/22
 * @Author: LTisme
 * @ClassName: UseSynchronized
 * @Description: --->
 */

public class UseSynchronized {

    private static  int COUNT = 0;

    // 使用synchronized方法，只要有一段线程使用这段代码，那么另外一段线程就不能碰这段代码
    private synchronized static void adder(){
        COUNT++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                COUNT++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                COUNT++;
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                if (i % 1000 == 0){
                    System.out.println("t3 = 在作噢");
                }
                adder();
            }
        });

        Thread t4 = new Thread(() -> {
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

        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("COUNT = " + COUNT);
    }
}
