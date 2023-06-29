package org.example.importantAnddifficultPoints.Enum;

/**
 * @Date: 2023/2/18
 * @Author: LTisme
 * @ClassName: LazyEnumSingleton
 * @Description: ---> 《Effective Java》这种方法在功能上与公有域方法相近，但是它更加简洁，无偿提供了序列化机制，绝对防止多次实例化，
 *                     即使是在面对复杂序列化或者反射攻击的时候。虽然这种方法还没有广泛采用，但是单元素的枚举类型已经成为实现 Singleton的最佳方法。
 *                                                                                      —-《Effective Java 中文版 第二版》
 */

public class LazyEnumSingleton {

    public LazyEnumSingleton(){}

    private static enum SingletonHolder{
        // INSTANCE 就是内部枚举类 SingletonHolder 的静态枚举常量，一旦在某处调用该枚举常量
        // 就会
        INSTANCE;
        private LazyEnumSingleton singleton;

        // 这个无参构造器，是用来给 LazyEnumSingleton 的内部枚举类 SingletonHolder 中的
        // INSTANCE 枚举实例常量作构造用的
        SingletonHolder(){
            this.singleton = new LazyEnumSingleton();
        }
    }

    public static void main(String[] args) {
        LazyEnumSingleton singleton = SingletonHolder.INSTANCE.singleton;
    }
}
