package org.example.importantAnddifficultPoints.MultiThreads.First_ExtendsThread_OverrideRunMethod;

/**
 * @Date: 2023/2/20
 * @Author: LTisme
 * @ClassName: UseThread
 * @Description: ---> 第一种，通过继承Thread，并重写run方法，但是要用start方法启动线程
 */

public class UseThread extends Thread{
    @Override
    public void run() {
        System.out.println(2);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(1);
        new UseThread().start();
//        Thread.sleep(1000);
        System.out.println(3);
    }
}
