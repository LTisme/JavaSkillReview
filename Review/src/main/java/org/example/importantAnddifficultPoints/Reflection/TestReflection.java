package org.example.importantAnddifficultPoints.Reflection;

/**
 * @Date: 2023/4/19
 * @Author: LTisme
 * @ClassName: TestReflection
 * @Description: ---> 反射一般有3种获取方法：
 * 1.Class.forName("全限定路径名的类名")
 * 2.类名.class
 * 3.对象.getClass()
 */

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class.forName("类名")
        Class<?> clazz1 = Class.forName("org.example.importantAnddifficultPoints.Reflection.Dog");
        System.out.println(clazz1);
        //2.类名.class
        Class<Dog> clazz2 = Dog.class;
        System.out.println(clazz2);
        //3.对象.getClass()
        Dog dog = new Dog();
        Class<? extends Dog> clazz3 = dog.getClass();
        System.out.println(clazz3);

        // 说明这些反射出来的类是同一个
        if (clazz1 == clazz2 && clazz2 == clazz3) {
            System.out.println("clazz1 == clazz2 && clazz2 == clazz3");
        }
    }
}
