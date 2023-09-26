package day3_JDBC.practics;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws Exception {
        //1、创建对象ServerSocket对象
        ServerSocket ss = new ServerSocket(6666);

        //2、监听客户端的连接
        Socket socket = ss.accept();//阻塞

        //3、从连接通道中获取输入流读取数据
        InputStream is = socket.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
        //方式一：while循环读取数据
//        int b;
//        while ((b=isr.read()) != -1) {
//            System.out.println((char)b);
//        }

        byte[] b = new byte[1024];
        int len = is.read(b);
        System.out.println(new String(b,0,len));

        //4、关闭资源
        is.close();
        ss.close();
    }
}
