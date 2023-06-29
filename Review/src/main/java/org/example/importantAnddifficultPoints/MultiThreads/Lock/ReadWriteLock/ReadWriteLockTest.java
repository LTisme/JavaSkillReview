package org.example.importantAnddifficultPoints.MultiThreads.Lock.ReadWriteLock;

import org.example.importantAnddifficultPoints.MultiThreads.ThreadUtils.ThreadUtils;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Date: 2023/2/23
 * @Author: LTisme
 * @ClassName: ReadWriteLock
 * @Description: ---> 读写锁，读的时候谁都可以读，但是写都不能写。
 *                          写的时候，谁都不能读，也不能写。
 */

public class ReadWriteLockTest {

    private static final ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock();

    private static int COUNT = 1;

    public static void main(String[] args) {
        // 同时读
        Runnable reader = () -> {
            // 读锁
            ReentrantReadWriteLock.ReadLock readLock = LOCK.readLock();
            // 获得读锁之后，写操作就无法进行，但是读线程可以同时读，并不会隔很长时间才能读一个
            readLock.lock();
            try {
                ThreadUtils.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " 在读数据，COUNT为：" + COUNT);
            } finally {
                readLock.unlock();
            }
        };

        // 只能有且只有一个线程在写，其他线程无法写或者读取
        Runnable writer = () -> {
            // 写锁
            ReentrantReadWriteLock.WriteLock writeLock = LOCK.writeLock();
            writeLock.lock();
            try {
                ThreadUtils.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " 在写数据，COUNT为：" + ++COUNT);
            } finally {
                writeLock.unlock();
            }
        };



        // 100个读者
        for (int i = 0; i < 100; i++) {
            new Thread(reader, "reader-" + i).start();
        }
        // 2个作者
        for (int i = 0; i < 2; i++) {
            new Thread(writer, "writer-" + i).start();
        }

    }
}
