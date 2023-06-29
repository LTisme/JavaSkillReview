package org.example.importantAnddifficultPoints.MultiThreads.OutOfOrderExecution;

/**
 * @Date: 2023/2/22
 * @Author: LTisme
 * @ClassName: OutOfOrderExecution
 * @Description: ---> 下面因为会有指令重排的存在，所以执行顺序有可能是①x=b；②y=a;③a=1；④b=1，从而导致x==0,y==0
 */

public class OutOfOrderExecution {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        // 用无限for循环来不停地创建线程
        for (;;){
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });

            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println("一共执行了：" + (count++) + "次");
            if(x==0 && y==0){
                long end = System.currentTimeMillis();
                System.out.println("耗时：+"+ (end-start) +"毫秒，(" + x + "," + y + ")");
                break;
            }
            a=0;b=0;x=0;y=0;
        }
    }
}
// 执行了接近400万次才出现该结果
//一共执行了：3914126次
//一共执行了：3914127次
//一共执行了：3914128次
//一共执行了：3914129次
//一共执行了：3914130次
//一共执行了：3914131次
//耗时：+628779毫秒，(0,0)
