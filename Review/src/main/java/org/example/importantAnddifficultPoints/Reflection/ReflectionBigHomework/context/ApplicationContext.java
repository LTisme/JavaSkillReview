package org.example.importantAnddifficultPoints.Reflection.ReflectionBigHomework.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Date: 2023/5/31
 * @Author: LTisme
 * @ClassName: ApplicationContext
 * @Description: ---> 这个类就是用来留存形成单例实例的容器，这样就能把所有类都在这里加载到内存，以后取类都可以在这里取
 */

public class ApplicationContext {

    private static final Map<Class<?>, Object> CONTEXT = new ConcurrentHashMap<>();

    public static void addSingleton(Class<?> clazz, Object entity){
        ApplicationContext.CONTEXT.put(clazz, entity);
    }

    // 用了泛型，取的时候就不用再强转了
    public static <T> T getSingleton(Class<T> clazz){
        return (T)ApplicationContext.CONTEXT.get(clazz);
    }
}
