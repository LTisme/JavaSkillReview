package org.example.importantAnddifficultPoints.MultiThreads.Third_Implement_Callable_Interface_with_Returns;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Date: 2023/2/20
 * @Author: LTisme
 * @ClassName: UseCallable
 * @Description: ---> 第三种，就算实现 Callable 接口，就要配合 Futuretask 使用，他是一个有返回值的线程
 */

public class UseCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // FutureTask 的目的是为了保存一个将来的返回值，这样用get方法阻塞时，
        // 就能够保证流程衔接，比如某个流程必须要得到你这个线程的返回值才能接下来继续运行
        FutureTask<Integer> futureTask = new FutureTask<>(new UseCallable());
        new Thread(futureTask).start();
        // get 方法是阻塞当前线程的，需要等待线程返回该值
        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}
