package org.example.importantAnddifficultPoints.Reflection.ReflectionBigHomework.handlers;

import org.example.importantAnddifficultPoints.Reflection.ReflectionBigHomework.annotations.Singleton;
import org.example.importantAnddifficultPoints.Reflection.ReflectionBigHomework.context.ApplicationContext;

import java.util.List;

/**
 * @Date: 2023/5/31
 * @Author: LTisme
 * @ClassName: SingletonHandler
 * @Description: ---> 这是注解解析器，将加了@Singleton注解的类放入容器
 */

public class SingletonHandler {

    public static void handle(List<String> classNames){
        // 拿到了全限定名，可以用反射方法————Class.forName("全限定名")拿到类
        // 然后再根据这个类是否有被@Singleton这个注解修饰，而生成单例实例并放入到容器中去
        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(Singleton.class)){
                    Object instance = clazz.newInstance();
                    ApplicationContext.addSingleton(clazz, instance);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}
