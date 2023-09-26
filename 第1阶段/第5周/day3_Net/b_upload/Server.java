package week5.day3_Net.b_upload;

import week5.day3_Net.Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //1、创建服务器的Sorket，指定自身端口
        ServerSocket ss = new ServerSocket(7777);
        Socket socket = ss.accept();//会阻塞，等待客户端发送

        InputStream is = socket.getInputStream();
        int len;
        byte[] b = new byte[1024];
        OutputStream os = new FileOutputStream("e:/c.jpg");
        while ((len = is.read(b)) != -1){
            os.write(b,0,len);
        }
        System.out.println("服务器存储成功");
        Utils.closeAll(is,os,socket);
    }
}
