package org.example.importantAnddifficultPoints.NIO;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * @Date: 2023/6/30
 * @Author: Administrator
 * @ClassName: NIOTest
 * @Description:
 */

public class NIOTest {

    @Test
    public void BufferTest() {
        // 创建Buffer
        CharBuffer buff = CharBuffer.allocate(8);                                           // ①
        System.out.println("capacity：" + buff.capacity());
        System.out.println("limit：" + buff.limit());
        System.out.println("position：" + buff.position());

        // 放入元素
        buff.put('a');
        buff.put('b');
        buff.put('c');                                                                      // ②
        System.out.println("加入3个元素后，position = " + buff.position());

        // 调用flip()方法
        buff.flip();                                                                        // ③
        System.out.println("\n执行flip()后，limit = " + buff.limit() + "；position = " + buff.position());

        // 取出第一个元素
        System.out.println("第一个元素（position = 0）：" + buff.get());                        // ④
        System.out.println("取出一个元素后，position = " + buff.position());

        // 调用clear方法
        buff.clear();                                                                       // ⑤
        System.out.println("\n执行clear()后，limit = " + buff.limit());
        System.out.println("执行clear()后，position = " + buff.position());
        System.out.println("执行clear()后，缓冲区并没有被清除， 第3个元素为：" + buff.get(2));      // ⑥
        System.out.println("执行绝对读取后，position = " + buff.position());
    }

    // 程序不能直接访问Channel中的数据，包括读取、写入都不行，Channel只能与Buffer交互。
    // 你可以不用flip来指示Buffer的指针，但是这样违背它的本意了
    @Test
    public void ChannelTest() throws IOException {
        // 所有的Channel都不应该通过构造器来直接创建，而是通过传统的节点InputStream、OutputStream等的
        // getChannel() 方法来返回对应的Channel。
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\LT\\ForLearning\\AboutCode\\Java\\All_Projects\\JavaSkillReview\\test.txt");
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.wrap("Hello, NIO!".getBytes());

        channel.write(byteBuffer);
        channel.close();
        fileOutputStream.close();
    }

    // 你应该用flip()来让指针处于正确的位置，只有这样，
    @Test
    public void ChannelTest2() throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\LT\\ForLearning\\AboutCode\\Java\\All_Projects\\JavaSkillReview\\test.txt");
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("Hello, NIO!".getBytes());

        // flip()若被注释，则会输出空白
        byteBuffer.flip();

        channel.write(byteBuffer);
        channel.close();
        fileOutputStream.close();
    }
}
