package org.example.importantAnddifficultPoints.Annotation;

// @interface的意思：@interface是用来修饰 Annotation的，它不是interface。这个
// 关键字声明隐含了一个信息：它是继承了 java.lang.annotation.Annotation 接口，而不是声明了一个
// interface。

public @interface

MyAnnotation1 {
    String name() default "李四";
    // 如果想要我们的属性不需要指定具体的参数名字，只需要将方法名字写成value()
    // 但如果你有多个参数传入，则value方法名也无法省略
    int age();
}
