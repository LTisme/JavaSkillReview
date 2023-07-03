package org.example.importantAnddifficultPoints.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Date: 2023/7/3
 * @Author: Administrator
 * @ClassName: NIOServer
 * @Description: 使用NIO来写个服务端。Java NIO中的 ServerSocketChannel 是一个可以监听新进来的TCP连接的通道, 就像标准IO中的ServerSocket一样。
 */

public class NIOServer {
    public static void main(String[] args) throws IOException {
        // 创建服务器
        ServerSocketChannel server = ServerSocketChannel.open();
        // 配置为非阻塞式IO
        server.configureBlocking(false);
        // 绑定到端口
        server.bind(new InetSocketAddress(6666));
        // 创建多路复用选择器
        Selector selector = Selector.open();
        // 然后将选择器注册到channel里去
        server.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            // 让选择器开启多路选择，这个选择方法就是一个阻塞的方法，返回的int值代表发生事件的通道数
            // 0 超时（如果你在select中加入了超时限定时间的话，不加就是一直等下去）
            // -1 错误
            int select = selector.select(1000);
            // 只要走到这里，必然发生了可读可写可连接的的channel
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            // 使用迭代器
            Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();

            while (selectionKeyIterator.hasNext()){
                SelectionKey selectionKey = selectionKeyIterator.next();
                // 这个事件一旦处理之后，就将其在迭代器中删除
                selectionKeyIterator.remove();
                if (selectionKey.isAcceptable()){
                    // 说明有客户端过来连接了，进行三次握手
                    System.out.println("有客户端连上了！");
                    // 连上了就能获得channel了
                    SocketChannel accept = server.accept();
                    // 让这个与客户端的channel变为非阻塞式的
                    accept.configureBlocking(false);
                    // 已经有channel火车轨道了，再来一个火车车厢，也就是Buffer，让后对读事件比较关心就让 SelectionKey 关心读事件
                    accept.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                if (selectionKey.isReadable()){
                    System.out.println("有信息可读。");
                    // 拿到了客户端的SocketChannel，就可以就行关心的读写之类的操作了
                    SocketChannel channel = (SocketChannel)selectionKey.channel();
                    // 通过下面的代码就能拿到之前设定的火车皮，就是ByteBuffer，人家就是这么设计的
                    ByteBuffer buffer = (ByteBuffer)selectionKey.attachment();
                    buffer.clear();
                    channel.read(buffer);
                    System.out.println(new String(buffer.array(), 0, buffer.position()));
                }
            }
        }
    }
}
