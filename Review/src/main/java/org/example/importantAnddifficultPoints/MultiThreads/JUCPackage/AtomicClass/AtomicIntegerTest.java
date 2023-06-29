package org.example.importantAnddifficultPoints.MultiThreads.JUCPackage.AtomicClass;

import org.example.importantAnddifficultPoints.MultiThreads.ThreadUtils.ThreadUtils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Date: 2023/2/24
 * @Author: LTisme
 * @ClassName: AtomicIntegerTest
 * @Description: ---> Atomic还有很多变体，但是一通百通，它的源码也用到了CAS方法和volatile关键字，来保证一致性和
 */

public class AtomicIntegerTest {

    private static final AtomicInteger atm = new AtomicInteger();

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            new Thread(atm::incrementAndGet).start();
        }

        ThreadUtils.sleep(2000);
        System.out.println("atm.get() = " + atm.get());
    }
}
