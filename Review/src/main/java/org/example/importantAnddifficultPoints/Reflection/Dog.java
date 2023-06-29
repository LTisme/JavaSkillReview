package org.example.importantAnddifficultPoints.Reflection;

import org.example.importantAnddifficultPoints.Annotation.MyAnnotation2;
import org.example.importantAnddifficultPoints.Reflection.ReflectionBigHomework.annotations.Singleton;

/**
 * @Date: 2023/4/19
 * @Author: LTisme
 * @ClassName: Dog
 * @Description: --->
 */

@MyAnnotation2(age = 222)
@Singleton
public class Dog {
    private String name;
    private int age;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Dog(String name) {
        this.name = name;
    }
    public Dog(int age) {
        this.age = age;
    }
    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
    }
    private Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    void eat() {
        System.out.println("eat");
    }

    void eat(String name, int num) {
        System.out.println("eat " + num + " " + name);
    }

    private String sleep(String name, int age) {
        return name + age;
    }

    public Dog() {
        this.age = 18;
        this.name = "teddy";
    }

    public void shout() {
        System.out.println("wang~");
    }
    public void run() {
        System.out.println("run");
    }
    public void sleep() {
        System.out.println("sleep");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
