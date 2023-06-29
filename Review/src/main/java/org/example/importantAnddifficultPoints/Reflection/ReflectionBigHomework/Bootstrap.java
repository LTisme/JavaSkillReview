package org.example.importantAnddifficultPoints.Reflection.ReflectionBigHomework;

import org.example.importantAnddifficultPoints.Reflection.Dog;
import org.example.importantAnddifficultPoints.Reflection.ReflectionBigHomework.annotations.Singleton;
import org.example.importantAnddifficultPoints.Reflection.ReflectionBigHomework.context.ApplicationContext;
import org.example.importantAnddifficultPoints.Reflection.ReflectionBigHomework.handlers.SingletonHandler;
import org.example.importantAnddifficultPoints.Reflection.ReflectionBigHomework.utils.FileUtils;

import java.net.URL;
import java.util.List;

/**
 * @Date: 2023/5/15
 * @Author: LTisme
 * @ClassName: Bootstrap
 * @Description: --->
 */

public class Bootstrap {
    // 我们想让类一加载，就进行解析处理，而不用main方法
    static {
        // 获取classpath根路径，方法是用当前的线程拿到当前的ClassLoader，这样能拿到资源，拿到URL
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
        // 通过一句话，就拿到所有的全限定名称，这样在main方法中就会看起来不是那么杂乱无章
        List<String> classNames = FileUtils.getAllFilesName(url.getPath());
        // 使用注解解析器Handler去处理注解
        SingletonHandler.handle(classNames);
    }

    public static void main(String[] args) {
        // 已经在Dog类上加上@Singleton修饰了，那么我们拿到Dog对象，直接从容器中拿就好了
        Dog dog = ApplicationContext.getSingleton(Dog.class);
        System.out.println(dog);
    }
}
