package org.example.importantAnddifficultPoints.SingletonsSumup;

/**
 * @Date: 2023/2/25
 * @Author: LTisme
 * @ClassName: ThreadSafe_LazySingleton_DoubleCheck
 * @Description: ---> 如果INSTANCE不用关键字 volatile 修饰的话，那么它就不是百分之百的线程安全，
 *                    会出现指令重排的问题
 *                    1、在堆内存中，申请空间
 *                    2、调用invokespecial 来调用 init方法，来初始化对象（比起步骤3，2显然耗时的多）
 *                    3、栈内引用指向堆内存空间
 *                    而在JVM中，认为2、3步骤是可以没有先后的，这就会有几率产生半初始化状态，譬如：
 *                    在一个线程到②的情况下，开始 new 单例对象，那么分配完空间，JVM先执行了3————也就是栈内已经指向堆内存空间了，但还没有调用init方法
 *                    这时候另一个线程执行到①处发现已经有引用指向了，立马把还没执行初始化的对象返回出去，那么，就会产生空指针异常了
 */

public class ThreadSafe_LazySingleton_DoubleCheck {

    private static volatile ThreadSafe_LazySingleton_DoubleCheck INSTANCE;    // 必须用 volatile 才能保证指令重排

    // 若不使用 volatile 关键字，则可能引起指令重排
//    private static ThreadSafe_LazySingleton_DoubleCheck INSTANCE;

    private ThreadSafe_LazySingleton_DoubleCheck(){}

    public static ThreadSafe_LazySingleton_DoubleCheck getInstance(){
        // ①
        if (INSTANCE == null){
            synchronized (ThreadSafe_LazySingleton_DoubleCheck.class){
                if (INSTANCE == null){
                    // ②
                    INSTANCE = new ThreadSafe_LazySingleton_DoubleCheck();
                }
                return INSTANCE;
            }
        }
        return INSTANCE;
    }
}
