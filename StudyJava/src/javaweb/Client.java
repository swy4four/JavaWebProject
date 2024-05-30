package javaweb;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket =new Socket("localhost",8080)){
            System.out.println("已连接到服务器");
        }catch(IOException e){
            System.out.println("连接服务器失败");
            e.printStackTrace();
        }
    }
}
