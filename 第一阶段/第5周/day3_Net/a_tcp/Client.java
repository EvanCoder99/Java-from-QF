package week5.day3_Net.a_tcp;

import week5.day3_Net.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端Socket对象，指定服务器的Ip和端口
        Socket socket = new Socket("127.0.0.1", 6666);

        //客户端发数据
        OutputStream os = socket.getOutputStream();
        os.write("Client说：奥利给".getBytes());

        //客户端接收资源
        InputStream is = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = is.read(b);
        System.out.println(new String(b,0,len));

        Utils.closeAll(is,os,socket);//os和is同级，所以随便谁先关闭都行，但socket要最后关
    }
}
