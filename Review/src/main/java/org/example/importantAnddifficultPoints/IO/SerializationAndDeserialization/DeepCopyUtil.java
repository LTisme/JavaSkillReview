package org.example.importantAnddifficultPoints.IO.SerializationAndDeserialization;

import java.io.*;

/**
 * @Date: 2023/4/17
 * @Author: LTisme
 * @ClassName: DeepCopyUtil
 * @Description: ---> 一个深拷贝用的封装好的工具，支持泛型
 */

public class DeepCopyUtil {

    public static <T> T deepCopy(T t) throws IOException, ClassNotFoundException {
        // 因为要用IO的方式，真正实际的将一个对象的字节流状态保存下来，所以这里选择字节数组来将该对象保存，然后再从这个数组中读出
        // 这是一个节点流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // 用处理流包装节点流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        // 将要写入字节数组的对象写入进去
        objectOutputStream.writeObject(t);
        // 写到哪里去了呢？当然是写到前面说的那个字节数组当中去了
        byte[] byteArray = outputStream.toByteArray();

        // 然后是读出该对象，采用上面的反向操作即可
        ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Object o = objectInputStream.readObject();
        // 关闭流，后打开的先关，先打开的后关
        objectInputStream.close();
        inputStream.close();
        objectOutputStream.close();
        outputStream.close();

        return (T)o;
    }
}
