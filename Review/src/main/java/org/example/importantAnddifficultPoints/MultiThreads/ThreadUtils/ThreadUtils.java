package org.example.importantAnddifficultPoints.MultiThreads.ThreadUtils;

/**
 * @Date: 2023/2/20
 * @Author: LTisme
 * @ClassName: ThreadUtils
 * @Description: ---> 这个类作为 Thread 的工具类，目的是 sleep总会抛异常，索性都在这里try catch好了
 */

public class ThreadUtils extends Thread{

    public static void sleep(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
