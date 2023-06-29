package org.example.importantAnddifficultPoints.MultiThreads.Second_Implement_Runnable_Interface;

/**
 * @Date: 2023/2/20
 * @Author: LTisme
 * @ClassName: UseRunnable2
 * @Description: ---> 这几乎是最方便的线程写法
 */

public class UseRunnable_lambda {
    public static void main(String[] args) {
        System.out.println(1);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(2);
//            }
//        }).start();
        new Thread(() -> System.out.println(2)).start();
        System.out.println(3);
    }
}
