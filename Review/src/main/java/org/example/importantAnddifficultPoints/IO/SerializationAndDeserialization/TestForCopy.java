package org.example.importantAnddifficultPoints.IO.SerializationAndDeserialization;

import java.io.Serializable;

/**
 * @Date: 2023/3/27
 * @Author: LTisme
 * @ClassName: TestForCopy
 * @Description: --->
 */
class Dog implements Serializable{

    public static final long SerialVersionUID = 2L;
    private String name;

    {
        this.name = "一只狗";
    }

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class TestForCopy implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private int age;

    private String name;

    private Dog dog;

    public TestForCopy() {
    }

    @Override
    protected TestForCopy clone() throws CloneNotSupportedException {
        return (TestForCopy)super.clone();
    }

    public TestForCopy(int age, String name) {
        this.age = age;
        this.name = name;
        this.dog = new Dog();
    }

    public TestForCopy(int age, String name, Dog dog) {
        this.age = age;
        this.name = name;
        this.dog = dog;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "TestForCopy{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }
}
