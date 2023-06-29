package org.example.importantAnddifficultPoints.MultiThreads.DaemonThread;

import org.example.importantAnddifficultPoints.MultiThreads.ThreadUtils.ThreadUtils;

/**
 * @Date: 2023/2/20
 * @Author: LTisme
 * @ClassName: UseDaemon
 * @Description: ---> 守护线程它的作用就是默默运行，被他守护的线程一旦消失，那么守护线程就消失了
 */

public class UseDaemon {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Thread t2 = new Thread(() -> {
                while (true){
                    ThreadUtils.sleep(200);
                    System.out.println("我是t2线程的守护线程");
                }
            });
            // 如果注释掉这句守护线程，则会无休止的继续打印，而不会在t1执行完了之后消亡退出
//            t2.setDaemon(true);
            t2.start();

            int count = 10;
            while (count >= 0){
                ThreadUtils.sleep(200);
                System.out.println("我是main线程里的t1线程");
                count--;
            }

            System.out.println("用户线程结束------------------------");
        });
//        t1.setDaemon(true);
        t1.start();
    }
}
