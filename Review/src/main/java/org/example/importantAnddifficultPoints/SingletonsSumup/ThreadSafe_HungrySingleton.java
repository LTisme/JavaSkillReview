package org.example.importantAnddifficultPoints.SingletonsSumup;

/**
 * @Date: 2023/2/25
 * @Author: LTisme
 * @ClassName: ThreadSafe_HungrySingleton
 * @Description: ---> 类在内存中只会加载一次，以后一直用的就是静态常量 INSTANCE 了
 */

public class ThreadSafe_HungrySingleton {

    private static ThreadSafe_HungrySingleton INSTANCE = new ThreadSafe_HungrySingleton();

    private ThreadSafe_HungrySingleton(){}

    public static ThreadSafe_HungrySingleton getInstance(){
        return INSTANCE;
    }
}
