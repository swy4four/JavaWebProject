package javaweb;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)){
            System.out.println("等待客户端链接 ");
            while(true){
                Socket socket=server.accept();//没有客户端 连接时线程阻塞 直到有客户端链接为止
                System.out.println("客户端已连接，ip 地址为："+socket.getInetAddress());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
