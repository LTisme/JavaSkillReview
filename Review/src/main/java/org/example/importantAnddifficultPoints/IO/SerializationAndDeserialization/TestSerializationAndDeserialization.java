package org.example.importantAnddifficultPoints.IO.SerializationAndDeserialization;

import org.testng.annotations.Test;

import java.io.*;

/**
 * @Date: 2023/3/22
 * @Author: LTisme
 * @ClassName: TestSerializationAndDeserialization
 * @Description: ---> 测试序列化和反序列化的一系列
 */

public class TestSerializationAndDeserialization {
    /**
     * 测试将一个可序列化对象写到一个文件中去，写进去后显示的一定是乱码，但是确实存进去了，你还可以把一个视频存到一个txt文件中去，毕竟只是字节信息
     * @throws IOException
     */
    @Test
    public void Test_writeSerializableObject() throws IOException {
        OutputStream outputStream = new FileOutputStream("D:\\Java_Practice_Files\\All_Projects\\JavaSkill\\Review\\src\\main\\java\\org\\example\\importantAnddifficultPoints\\IO\\SerializationAndDeserialization\\storage.txt");
        // Java中万物皆对象，所以，得用Object的方法来读取对象，或者写入对象
        ObjectOutput objectOutput = new ObjectOutputStream(outputStream);
        objectOutput.writeObject(new TestForSerialization());
        objectOutput.close();
        outputStream.close();
    }

    @Test
    public void Test_readSerializableObject() throws IOException, ClassNotFoundException {
        InputStream outputStream = new FileInputStream("D:\\Java_Practice_Files\\All_Projects\\JavaSkill\\Review\\src\\main\\java\\org\\example\\importantAnddifficultPoints\\IO\\SerializationAndDeserialization\\storage.txt");
        // Java中万物皆对象，所以，得用Object的方法来读取对象，或者写入对象
        ObjectInput objectInput = new ObjectInputStream(outputStream);
        System.out.println(objectInput.readObject());
        objectInput.close();
        outputStream.close();
    }

    /**
     * 测试浅拷贝
     * @throws CloneNotSupportedException
     */
    @Test
    public void Test_shallowCopy() throws CloneNotSupportedException {
        // 以下的TestForCopy对象是已经做过版本号识别的，所以序列化后，即使更改一些这对象的一些方法，属性，仍然可以被反序列化出来，只不过新方法可能用不了
        TestForCopy testForCopy = new TestForCopy(12, "张三");
        testForCopy.setDog(new Dog("teddy"));

        TestForCopy testForCopy1 = testForCopy.clone();
        testForCopy.setAge(22);
        // 从下面的结果可以看到，它们是不同的对象，而且，你还可以打印hashCode来判断
        System.out.println(testForCopy1);
        System.out.println(testForCopy);
        // 但是下面的修改，会发现内部的对象并没有复制成一个新对象，而是直接进行了引用，所以这是个浅拷贝
        testForCopy.getDog().setName("husky");
        System.out.println(testForCopy1);
        System.out.println(testForCopy);
    }

    /**
     * 测试深拷贝——这里的思路是将一个对象（字节对象）写入到字节数组（这样做即使做了改动也不会影响到已经存储的数据），然后再将字节数组中的对象读出
     * @throws CloneNotSupportedException
     */
    @Test
    public void Test_deepCopy1() throws IOException, ClassNotFoundException {
        TestForCopy tp1 = new TestForCopy(18, "李四", new Dog("teddy"));

        // 因为要用IO的方式，真正实际的将一个对象的字节流状态保存下来，所以这里选择字节数组来将该对象保存，然后再从这个数组中读出
        // 这是一个节点流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // 用处理流包装节点流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        // 将要写入字节数组的对象写入进去
        objectOutputStream.writeObject(tp1);
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

        // 通过下面发现，就算是对象里面的内部对象，也是完完全全复制了一份出来，做了一个独立个体
        tp1.setAge(22);
        tp1.setName("王五");
        tp1.getDog().setName("husky");
        System.out.println(tp1);
        System.out.println(((TestForCopy)o).toString());
        // 可以看到，长长的这么一段，做的就是一份对象复制工作，从而可以进行封装——请看DeepCopyUtil
    }

    /**
     * 工具类写好后，下次就不用上面那一堆了
     */
    @Test
    public void Test_deepCopy2() throws IOException, ClassNotFoundException {
        TestForCopy tp1 = new TestForCopy(18, "李四", new Dog("teddy"));
        TestForCopy tp2 = DeepCopyUtil.deepCopy(tp1);

        tp1.setAge(22);
        tp1.setName("王五");
        tp1.getDog().setName("husky");
        System.out.println(tp1);
        System.out.println(tp2.toString());
    }
}
