package org.example.importantAnddifficultPoints.Reflection;

import org.example.importantAnddifficultPoints.Annotation.MyAnnotation2;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Date: 2023/4/19
 * @Author: LTisme
 * @ClassName: TestReflection2
 * @Description: --->
 */

public class TestReflection2 {
    Class<Dog> clazz = null;

    @BeforeTest
    public void init() {
        clazz = Dog.class;
    }

    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        System.out.println("clazz.isPrimitive() = " + clazz.isPrimitive());
        System.out.println("clazz.isArray() = " + clazz.isArray());
        System.out.println("clazz.isLocalClass() = " + clazz.isLocalClass());
        System.out.println("clazz.isMemberClass() = " + clazz.isMemberClass());
        System.out.println("clazz.isSynthetic() = " + clazz.isSynthetic());
        System.out.println("clazz.isInterface() = " + clazz.isInterface());
        System.out.println("clazz.isAnnotation() = " + clazz.isAnnotation());
        System.out.println("clazz.isEnum() = " + clazz.isEnum());

        Dog dog = clazz.newInstance();
        dog.eat();
        dog.setName("小黄");
        System.out.println("dog.getName() = " + dog.getName());
    }

    /**
     * 这里使用反射来获取类中的成员变量
     */
    @Test
    public void FieldTest() {
        // 这个方法只能拿到public修饰的成员变量
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }

        System.out.println("=======================");
        // 而这个方法可以弄到所有的成员变量，也就是获取所有的声明了的变量
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }

        // 这里测试用反射获取成员变量后，给成员变量赋值
        try {
            Field name = clazz.getDeclaredField("name");
            // 这里必须要设置权限为true，否则无法修饰private修饰的成员变量
            name.setAccessible(true);
            Dog dog = new Dog();
            // 暴力注入
            name.set(dog, "小黎");
            System.out.println("dog.getName() = " + dog.getName());
            Object o = name.get(dog);
            System.out.println("o = " + (String) o);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred!");
        }
    }

    /**
     * 这里使用反射来获取类中的方法成员变量
     */
    @Test
    public void MethodTest() throws NoSuchMethodException {
        // 这两两方法都数据郯同样的
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        System.out.println("=======================");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod = " + declaredMethod);
        }

        // 这里调用反射获取到的方法，方法调用只有一个，就是invoke

        Method eat = clazz.getDeclaredMethod("eat");
        Method eat2 = clazz.getDeclaredMethod("eat", String.class, int.class);
        // eat() 方法如果是用private修饰的话，使用开通权限就行
//        eat.setAccessible(true);
//        eat2.setAccessible(true);
        try {
            eat.invoke(new Dog());
            eat2.invoke(new Dog(), "香蕉", 5);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 这里使用反射来获取类中的构造器
     *
     * @throws NoSuchMethodException
     */
    @Test
    public void ConstructorTest() throws NoSuchMethodException {
        // 这两方法是同样的
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("constructor = " + constructor);
        }

        System.out.println("=======================");
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("declaredConstructor = " + declaredConstructor);
        }

        // 这里调用反射获取到的构造器，获取String为入参类型的构造器
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
        try {
            // 如果是私有的，还可以开通权限来获取它
            declaredConstructor.setAccessible(true);
            Dog dog = (Dog) declaredConstructor.newInstance("小黎");
            System.out.println("dog.getName() = " + dog.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 这里使用反射获取类中的注解，注意，很需要对方注解的@Retention要用RetentionType.RUNTIME来配合，不然反射获取不到
     *
     * @throws NoSuchFieldException
     */
    @Test
    public void AnnotationTest() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException {
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
        }

        System.out.println("=======================");

        Field name = clazz.getDeclaredField("name");
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);

        // 这里使用反射检查类上面的目标注解是否存在，存在的话就获得它
        if (name.isAnnotationPresent(MyAnnotation2.class)) {
            MyAnnotation2 annotation = name.getAnnotation(MyAnnotation2.class);
            System.out.println("annotation.age() = " + annotation.age());
            System.out.println("annotation.name() = " + annotation.name());
        }
        if (age.isAnnotationPresent(MyAnnotation2.class)) {
            MyAnnotation2 annotation = age.getAnnotation(MyAnnotation2.class);
            System.out.println("annotation.age() = " + annotation.age());
            System.out.println("annotation.name() = " + annotation.name());
        }

        System.out.println("=======================");

        // 这里使用反射检查类上面的目标注解是否存在，存在的话就获得它
        if (clazz.isAnnotationPresent(MyAnnotation2.class)) {
            MyAnnotation2 annotation = clazz.getAnnotation(MyAnnotation2.class);
            System.out.println("annotation.age() = " + annotation.age());
            System.out.println("annotation.name() = " + annotation.name());
        }
    }
}
