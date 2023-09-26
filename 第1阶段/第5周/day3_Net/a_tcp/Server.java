package week5.day3_Net.a_tcp;

import week5.day3_Net.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //1、创建服务器的Sorket，指定自身端口
        ServerSocket ss = new ServerSocket(6666);
        Socket socket = ss.accept();//会阻塞，等待客户端发送

        //服务器接收
        InputStream is = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = is.read(b);
        System.out.println(new String(b,0,len));

        //服务器发数据
        OutputStream os = socket.getOutputStream();
        os.write("Server说：奥利给".getBytes());

        Utils.closeAll(os,is,socket);
    }
}
