package org.example.importantAnddifficultPoints;

/**
 * @Date: 2023/1/16
 * @Author: LTisme
 * @ClassName: InterfaceAnimal
 * @Description: --->
 */
interface Interface_Animal {

    // 这是静态常量，只不过系统自动帮你添上public static final，如下可以看到
    int MAX_CACHE_SIZE = 50;

    // 1.接口可以定义成员变量————系统自动加了public static final 所以手动添加是冗余的
    public static final int MIN_CACHE_SIZE = 30;

    // 2.0接口可以定义三种方法
    // 2.1第一种————类方法（需要自己手动添加static，但系统会自动添加public，手动添加public是冗余操作）
    // 它的作用是：可以直接通过接口进行调用，就像类方法
    public static void staticTest(){
        System.out.println("接口里的类方法");
    }

    // 2.2第二种————私有方法(需要自己手动添加private），也就是只能在这个接口类中使用的方法
    // 它的作用是：只能在这个接口类中进行调用，就像私有的一样
    private void foo(){
        System.out.println("Private foo");
    }

    // 也可以是静态私有的方法
    private static void foo1(){
        System.out.println("Private static foo1");
    }

    // 2.3第三种————默认方法
    // 它的作用是：必须由实现该接口的实现类的对象进行调用（就像实例方法）
    default void bar(){
        foo();
        foo1();
        System.out.println("Default bar");
    }

    // 2.4第四种————抽象实例方法(不用自己加abstract，因为它自动在编译时加public abstract，不用自己手动加，当然加了也行)
    // 它的作用是：自然需要被实现这个接口的类进行如何具体实现的补充了
    public abstract void getData(String msg);
}

public class InterfaceAnimal implements Interface_Animal{
    @Override
    public void getData(String msg) {
        System.out.println("This is InterfaceAnimal: " + msg);
    }

    public static void main(String[] args) {
        Interface_Animal.staticTest();
        System.out.println(Interface_Animal.MAX_CACHE_SIZE);
        System.out.println(Interface_Animal.MIN_CACHE_SIZE);
        InterfaceAnimal animal = new InterfaceAnimal();
        animal.bar();
        animal.getData("hi, animal!");
    }
}
