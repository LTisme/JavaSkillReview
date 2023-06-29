package org.example.importantAnddifficultPoints.MultiThreads.Second_Implement_Runnable_Interface;

/**
 * @Date: 2023/2/20
 * @Author: LTisme
 * @ClassName: UseRunnable
 * @Description: ---> 第二种，实现Runnable 接口，然后也是重写run方法
 */

public class UseRunnable_normal implements Runnable{
    @Override
    public void run() {
        System.out.println(2);
    }

    public static void main(String[] args) {
        System.out.println(1);
        new Thread(new UseRunnable_normal()).start();
        System.out.println(3);
    }
}
