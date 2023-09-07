package day4_DAO.g_practics;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class b_server {
    public static void main(String[] args) throws IOException {
        //创建服务端对象，并绑定端口
        ServerSocket ss = new ServerSocket(10086);

        //等待客户端连接
        Socket socket = ss.accept();

        //socket中获取输入流，读取数据
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
//        byte[] b = new byte[1024];
        int len;
        while ((len = isr.read()) != -1) {

            System.out.println((char)len);
        }


        //回传数据，写入客户端
        String s = "到底有多开心";
        OutputStream os = socket.getOutputStream();
        os.write(s.getBytes());

        is.close();
        socket.close();
        ss.close();
    }
}
