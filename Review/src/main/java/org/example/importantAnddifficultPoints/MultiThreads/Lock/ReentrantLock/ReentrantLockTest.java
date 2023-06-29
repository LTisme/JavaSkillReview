package org.example.importantAnddifficultPoints.MultiThreads.Lock.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date: 2023/2/23
 * @Author: LTisme
 * @ClassName: ReentrantLockTest
 * @Description: ---> 可重入锁的使用，锁天生具有可重入性，也就是获得该锁后要想再次获得该锁是完全可以的
 */

public class ReentrantLockTest {

    private static int tickets = 100;

    private static final ReentrantLock LOCK = new ReentrantLock();

    private static void soldTicket(){
        System.out.println(Thread.currentThread().getName() + " 开始卖票，总数 " + tickets + " 卖出1张，还剩 " + --tickets + " 张。");
    }

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    LOCK.lock();
                    soldTicket();
                }finally {
                    LOCK.unlock();
                }
            }
        }, "Thread-1").start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    LOCK.lock();
                    soldTicket();
                }finally {
                    LOCK.unlock();
                }
            }
        }, "Thread-2").start();
    }
}
