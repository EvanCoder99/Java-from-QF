package week5.day3_Net.dayWork.test1;

import week5.day3_Net.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//1.使用socket完成,客户端发送信息,服务器接收信息(使用字节流收发数据)
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6666);

        OutputStream os = socket.getOutputStream();
        os.write("我是客户端...".getBytes());

        InputStream is = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = is.read(b);
        System.out.println(new String(b,0,len));

        Utils.closeAll(os,is,socket);


    }
}
