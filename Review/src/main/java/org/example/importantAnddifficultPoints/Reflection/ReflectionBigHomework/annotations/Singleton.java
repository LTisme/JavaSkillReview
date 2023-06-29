package org.example.importantAnddifficultPoints.Reflection.ReflectionBigHomework.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Date: 2023/5/31
 * @Author: LTisme
 * @EnumClassName: Singleton
 * @Description: ---> 凡是被这个注解修饰的类，都只能生成一个单例实例
 */

// 只能用来修饰类、接口、枚举类等类
@Target(ElementType.TYPE)
// 因为需要被反射来扫包扫到，所以需要让他留存到运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface Singleton {
}
