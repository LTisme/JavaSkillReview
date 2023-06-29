package org.example.importantAnddifficultPoints.Annotation;

/**
 * @Date: 2023/4/17
 * @Author: LTisme
 * @ClassName: TestAnnotation
 * @Description: ---> 初步给 MyAnnotation 注解做测试
 */

public class TestAnnotation {
    private String name;
    private int age;

    public TestAnnotation() {
    }

    @MyAnnotation1(name = "张三", age = 18)
    public TestAnnotation(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        System.out.println(1);

        TestAnnotation testAnnotation = new TestAnnotation();

        System.out.println(testAnnotation.getName());
    }
}
