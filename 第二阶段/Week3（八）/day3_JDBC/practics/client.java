package day3_JDBC.practics;

import java.io.OutputStream;
import java.net.Socket;
import java.io.IOException;
import java.io.OutputStream;

public class client {
    public static void main(String[] args) throws Exception {
        //1、创建Soket对象
        //创建的同时就会连接服务器
        Socket socket = new Socket("127.0.0.1", 6666);

        //2、从连接通道中获取输出流
        OutputStream os = socket.getOutputStream();
        os.write("你好你好".getBytes());//写出数据

        //3、释放资源
        os.close();
        socket.close();
    }
}
