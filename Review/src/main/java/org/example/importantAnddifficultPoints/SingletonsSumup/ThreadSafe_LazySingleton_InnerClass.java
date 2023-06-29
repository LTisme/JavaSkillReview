package org.example.importantAnddifficultPoints.SingletonsSumup;

/**
 * @Date: 2023/2/25
 * @Author: LTisme
 * @ClassName: ThreadSafe_LazySingleton_InnerClass
 * @Description: ---> 用内部类的方式实现线程安全的懒汉加载式的单例类
 *                    只要不调用getInstance()方法，就不会使用内部类，
 *                    内部类一旦被使用只会被初始化一次，以后一直用的就是静态常量 INSTANCE 了。
 */

public class ThreadSafe_LazySingleton_InnerClass {

    /** 私有化构造器 */
    private ThreadSafe_LazySingleton_InnerClass() {
    }

    /** 写一个静态内部类，里面实例化外部类 */
    private static class ThreadSafe_LazySingleton_InnerClass_SingletonHolder{
        private static final ThreadSafe_LazySingleton_InnerClass INSTANCE = new ThreadSafe_LazySingleton_InnerClass();
    }

    /** 对外提供公共的访问方法 */
    public static ThreadSafe_LazySingleton_InnerClass getInstance() {
        return ThreadSafe_LazySingleton_InnerClass_SingletonHolder.INSTANCE;
    }


}
