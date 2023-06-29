package org.example.importantAnddifficultPoints.SingletonsSumup;

/**
 * @Date: 2023/2/25
 * @Author: LTisme
 * @ClassName: NonThreadSafe_LazySingleton
 * @Description: ---> 非线程安全的懒汉式单例类，它之所以不安全
 * 是因为多线程情况下，Instance == null 这个判断语句就有可能会产生误判，导致 new 了多个对象
 */

public class NonThreadSafe_LazySingleton {

    private static NonThreadSafe_LazySingleton INSTANCE;

    private NonThreadSafe_LazySingleton() {
    }

    public static NonThreadSafe_LazySingleton getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new NonThreadSafe_LazySingleton();
        }
        return INSTANCE;

    }
}
