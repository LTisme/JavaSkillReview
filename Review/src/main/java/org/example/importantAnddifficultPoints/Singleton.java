package org.example.importantAnddifficultPoints;

/**
 * @Date: 2023/1/6
 * @Author: LTisme
 * @ClassName: Singleton
 * @Description: ---> 单例类——一旦把该类的构造器隐藏起来，就需要提供一个public方法作为该类的访问点，用于创
 *                    建该类的对象，而且该方法必须用static修饰（因为调用该方法前还不存在实例对象），而且还需要用成员变量将
 *                    创建的对象缓存起来，防止被回收。
 */

// 立即加载就是使用类的时候已经将对象创建完毕（不管以后会不会使用到该实例化对象，先创建了再说。很着急的样子，故又被称为“饿汉模式”）
class HungrySingleton{
    private HungrySingleton(){}

    private static final HungrySingleton Instance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return Instance;
    }
}

// 先不急着实例化出对象，等要用的时候才给你创建出来。不着急，故又称为“懒汉模式”
// 这种懒汉式在多线程环境中是完全错误的，根本不能保证单例的状态
class LazySingleton{

    private LazySingleton(){};

    private static LazySingleton Instance;

    public static LazySingleton getInstance() {
        if (Instance == null){
            Instance = new LazySingleton();
        }
        return Instance;
    }
}

// 这种也是懒汉式的一种实现，而且使用这种懒汉式没有任何的线程问题
// 结合咱们上边的内容，只要不调用getInstance()方法，就不会使用内部类，内部类一旦被使用只会被初始化一次，以后一直用的就是静态常量 INSTANCE 了
class GoodLazySingleton{

    private GoodLazySingleton(){};

    // 静态内部类会在第一次使用这个静态内部类的时候才会加载到内存当中去
    private static class SingletonHolder{
        private static final GoodLazySingleton INSTANCE = new GoodLazySingleton();
    }

    public static GoodLazySingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

public class Singleton {
    public static void main(String[] args) {
        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
        HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();

        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();

        GoodLazySingleton goodLazySingleton1 = GoodLazySingleton.getInstance();
        GoodLazySingleton goodLazySingleton2 = GoodLazySingleton.getInstance();

        System.out.println(hungrySingleton1 == hungrySingleton2);
        System.out.println(lazySingleton1 == lazySingleton2);
        System.out.println(goodLazySingleton1 == goodLazySingleton2);
    }
}
