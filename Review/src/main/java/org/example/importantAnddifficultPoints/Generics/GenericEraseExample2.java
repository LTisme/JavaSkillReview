package org.example.importantAnddifficultPoints.Generics;

import java.util.Date;

/**
 * @Date: 2023/2/14
 * @Author: LTisme
 * @ClassName: GenericEraseExample2
 * @Description: ---> 【问题来了】 既然为了兼容进行泛型擦除，那么JVM都会统一的把有泛型的地方改写为Object
 *                    那么父类的setValue方法签名是 public void setValue(Object value)，方法签名都不同了，应该是重载才对，怎么会是重写呢？
 *                    这就需要看字节码了 javap -v 来看，JVM会用桥接方法来解决
 */

public class GenericEraseExample2 extends GenericEraseExample1<Date>{
    @Override
    public Date getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Date value) {
        super.setValue(value);
    }

    public static void main(String[] args) {
        GenericEraseExample2 genericEraseExample2 = new GenericEraseExample2();
        genericEraseExample2.setValue(new Date());
    }
}

/**下面的字节码可以看到，JVM做了一个桥接方法，setValue
 *
 */

//Compiled from "GenericEraseExample2.java"
//public class org.example.importantAnddifficultPoints.Generics.GenericEraseExample2 extends org.example.importantAnddifficultPoints.Generics.GenericEraseExample1<java.util.Date> {
//public org.example.importantAnddifficultPoints.Generics.GenericEraseExample2();
//        Code:
//        0: aload_0
//        1: invokespecial #1                  // Method org/example/importantAnddifficultPoints/Generics/GenericEraseExample1."<init>":()V
//        4: return
//
//public java.util.Date getValue();
//        Code:
//        0: aload_0
//        1: invokespecial #7                  // Method org/example/importantAnddifficultPoints/Generics/GenericEraseExample1.getValue:()Ljava/lang/Object;
//        4: checkcast     #11                 // class java/util/Date
//        7: areturn

/**【重点看】invokespecial 它入参类型是Date，但是调用了Object入参类型的重载方法。所以说虽是重写，但实际是在JVM里面调用了JVM桥接的重载方法，JVM这样做可以，你这样做就不行
 *
 */
//public void setValue(java.util.Date);
//        Code:
//        0: aload_0
//        1: aload_1
//        2: invokespecial #13                 // Method org/example/importantAnddifficultPoints/Generics/GenericEraseExample1.setValue:(Ljava/lang/Object;)V
//        5: return
//
//public static void main(java.lang.String[]);
//        Code:
//        0: new           #17                 // class org/example/importantAnddifficultPoints/Generics/GenericEraseExample2
//        3: dup
//        4: invokespecial #19                 // Method "<init>":()V
//        7: astore_1
//        8: aload_1
//        9: new           #11                 // class java/util/Date
//        12: dup
//        13: invokespecial #20                 // Method java/util/Date."<init>":()V
//        16: invokevirtual #21                 // Method setValue:(Ljava/util/Date;)V
//        19: return
/**【重点看】你看，JVM擦除泛型后，桥接了个重载方法，让入参为Date的重写方法调用它这个重载方法
 *
 */
//public void setValue(java.lang.Object);
//        Code:
//        0: aload_0
//        1: aload_1
//        2: checkcast     #11                 // class java/util/Date
//        5: invokevirtual #21                 // Method setValue:(Ljava/util/Date;)V
//        8: return
//
//public java.lang.Object getValue();
//        Code:
//        0: aload_0
//        1: invokevirtual #24                 // Method getValue:()Ljava/util/Date;
//        4: areturn
