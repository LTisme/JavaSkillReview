package org.example.importantAnddifficultPoints.MultiThreads.UseSynchronized;

import org.example.importantAnddifficultPoints.MultiThreads.ThreadUtils.ThreadUtils;

/**
 * @Date: 2023/2/22
 * @Author: LTisme
 * @ClassName: MultipleSynchronized
 * @Description: ---> 在这里列出各种 synchronized 使用的场景：可修饰 实例方法、静态方法、代码块
 *                    与同步代码块对应，还可以使用 synchronized 关键字来修饰某个方法，这个方法就称为同步方法。对于使
 *                    用 synchronized 修饰的实例方法而言，无须显式指定同步监视器，因为同步监视器就是this，也就是调用该方法
 *                    的对象；而对于使用 synchronized 的静态方法而言，同步监视器就是类对象Class对象。（这是非常容易搞混的
 *                    地方，不搞清楚这个，一下子创建几十个线程，就会有几十把锁）
 */

public class MultipleSynchronized {

    public static final Object MONITOR = new Object();
    public static final MultipleSynchronized THIS = new MultipleSynchronized();

    public synchronized void say(){
        ThreadUtils.sleep(100);
        System.out.println("say");
    }

    public static synchronized void sayHello(){
        ThreadUtils.sleep(100);
        System.out.println("hello");
    }

    public static void method(){
        synchronized (MultipleSynchronized.MONITOR){
            new Thread(() -> {
                sayHello();
                System.out.println("-------" + Math.random() + "-------");
            }).start();
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 50; i++) {
//            new Thread(() -> {
//                sayHello();
//                System.out.println("-------" + Math.random() + "-------");
//            }).start();
//        }

//        for (int i = 0; i < 50; i++) {
//            method();
//        }

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                THIS.say();
                System.out.println("-------" + Math.random() + "-------");
            }).start();
        }
    }
}
