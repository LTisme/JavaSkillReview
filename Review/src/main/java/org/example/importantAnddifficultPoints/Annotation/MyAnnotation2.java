package org.example.importantAnddifficultPoints.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Date: 2023/4/17
 * @Author: LTisme
 * @EnumClassName: MyAnnotation2
 * @Description: ---> 这个注解会写一些关于元注解的一些用途回顾
 * 【Target】 它用于指定被修饰的注解能用于修饰哪些程序单元。
 *                    ElementType.ANNOTATION_TYPE：指定该策略的注解只能修饰注解。
 *                    ElementType.CONSTRUCTOR：指定该策略的注解只能修饰构造器。
 *                    ElementType.FIELD：指定该策略的注解只能修饰成员变量。
 *                    ElementType.LOCAL_VARIABLE：指定该策略的注解只能修饰局部变量。
 *                    ElementType.METHOD：指定该策略的注解只能修饰方法定义。
 *                    ElementType.PACKAGE：指定该策略的注解只能修饰包定义。
 *                    ElementType.PARAMETER：指定该策略的注解只能修饰参数。
 *                    ElementType.TYPE：指定该策略的注解只能修饰类、接口（包括注解类型）或枚举定义。
 * 【Retention】 用于指定被修饰的注解可以保留多长时间。
 *                    RetentionPolicy.SOURCE：注解只保留在源码中，编译器直接丢掉这种注解。
 *                    RetentionPolicy.CLASS：编译器将把注解记录在class文件中。当运行Java程序时，JVM不可以获取注解信息。这是【默认值】。
 *                    RetentionPolicy.RUNTIME：编译器将把注解记录在class文件中。当运行Java程序时，JVM可以获取注解信息，程序也可以通过反射获取该注解信息。
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotation2 {
    String name() default "小狗";
    // 如果想要我们的属性不需要指定具体的参数名字，只需要将方法名字写成value()
    // 但如果你有多个参数传入，则value方法名也无法省略
    int age();
}
