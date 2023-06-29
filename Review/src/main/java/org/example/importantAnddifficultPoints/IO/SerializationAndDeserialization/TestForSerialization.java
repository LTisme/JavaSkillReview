package org.example.importantAnddifficultPoints.IO.SerializationAndDeserialization;

import java.io.Serializable;

/**
 * @Date: 2023/3/22
 * @Author: LTisme
 * @ClassName: TestForSerialization
 * @Description: ---> 被序列化或反序列化读取的class文件都需要实现 Serializable 接口
 */

public class TestForSerialization implements Serializable {

    // 加了序列化版本号，即便这个类进行了版本更新迭代，那么只要版本号一致，JVM也会认为保存的，读取的是这个类，或者說写入的是这个类
    private static final long serialVersionUID = 1L;

    private int age = 20;

    // 加了transient 修饰之后，那么这个字段就不会被序列化
//    private transient String name = "zhangsan";

    private String name = "zhangsan";

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestForSerialization{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
