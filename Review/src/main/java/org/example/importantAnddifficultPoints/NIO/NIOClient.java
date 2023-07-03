package org.example.importantAnddifficultPoints.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @Date: 2023/7/3
 * @Author: Administrator
 * @ClassName: NIOClient
 * @Description:
 */

public class NIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        // 让客户端也做一个非阻塞式的连接
        socketChannel.configureBlocking(false);
        // 客户端则不需要绑定端口了，直接连接就行（当然要知道目标主机的端口号是多少）
        socketChannel.connect(new InetSocketAddress(6666));

        // 只有连接成功才能正常运行
        // 否则会出 java.nio.channels.NotYetConnectedException 异常
        if (socketChannel.finishConnect()){
            // 用Scanner让客户端能一直发送信息
            while (true){
                Scanner scanner = new Scanner(System.in);
                String message = scanner.next();
                if (message == "quit"){
                    socketChannel.write(ByteBuffer.wrap("用户退出".getBytes()));
                    break;
                }
                // 把信息包装起来发出去
                socketChannel.write(ByteBuffer.wrap(message.getBytes()));
            }
        }
    }
}
