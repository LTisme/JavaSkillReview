package org.example.importantAnddifficultPoints.MultiThreads.OutOfOrderExecution;

import org.example.importantAnddifficultPoints.MultiThreads.ThreadUtils.ThreadUtils;

/**
 * @Date: 2023/2/22
 * @Author: LTisme
 * @ClassName: UseVolatile
 * @Description: ---> volatile关键字来保证一个变量在一次读写操作时的避免<<<指令重排 >>>，
 *                   【内存屏障】是在我们的读写操作之前加入一条指令，当CPU碰到这条指令后必须等到前边的指令执行完成才能继续执行下一条指令。
 *
 *                   不仅如此，volatile 还能避免<<<可见性问题 >>>
 *
 *                   用于标记一个变量“应当存储在主存”。更确切地说，每次读取volatile变量，都应该从主存读取，而不是从CPU缓存读取。
 *                   每次写入一个volatile变量，应该写到主存中，而不是仅仅写到CPU缓存。
 *
 *                   所以使用了volatile后，在进行写操作时，能立马强制将值刷到主存，并且让已经在缓存区的值设置为不可用。
 */

public class UseVolatile {

    private static volatile boolean flag = false;

    public static void main(String[] args) {

        // 如果不用volatile关键字修饰flag，则因为一直空转，高速读取，CPU是将flag放在高速缓存区进行不断的循环。所以即使是在主存区修改了flag的值，
        // 缓存区它也看不到已作修改
        new Thread(() -> {
            while (!flag){}
            System.out.println("能看见我吗？");
        }).start();

        ThreadUtils.sleep(2000);
        flag = true;
    }
}
