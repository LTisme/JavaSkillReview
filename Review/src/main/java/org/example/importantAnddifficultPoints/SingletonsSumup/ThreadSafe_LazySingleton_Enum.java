package org.example.importantAnddifficultPoints.SingletonsSumup;

/**
 * @Date: 2023/2/25
 * @Author: LTisme
 * @ClassName: ThreadSafe_LazySingleton_Enum
 * @Description: --->《Effective Java》这种方法在功能上与公有域方法相近，但是它更加简洁，无偿提供了序列化机制，
 *                    绝对防止多次实例化，即使是在面对复杂序列化或者反射攻击的时候。虽然这种方法还没有广泛采用，但是单元素的枚举类型已经成为实现 Singleton的最佳方法。
 *                                                                                  ————《Effective Java 中文版 第二版》
 */

public class ThreadSafe_LazySingleton_Enum {

    // 无论是哪种单例实现，单例类的构造器都是私有的
    private ThreadSafe_LazySingleton_Enum(){}

    private static enum SingletonHolder{
        INSTANCE;
        private final ThreadSafe_LazySingleton_Enum instant;

        SingletonHolder(){
            instant = new ThreadSafe_LazySingleton_Enum();
        }
    }

    // 对外暴露public方法
    public static ThreadSafe_LazySingleton_Enum getInstance(){
        return SingletonHolder.INSTANCE.instant;
    }
}
