package day4_DAO.g_practics;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class b_client {
    public static void main(String[] args) throws IOException {
        //创建Socket对象连接服务端
        Socket socket = new Socket("127.0.0.1", 10086);

        //写数据
        String s = "见到你很高兴";
        OutputStream os = socket.getOutputStream();
        os.write(s.getBytes());
        socket.shutdownOutput();

        //接收服务端回传来的数据
        InputStream is = socket.getInputStream();
        byte[] b = new byte[1024];
        int len;
        while ((len = is.read(b)) != -1) {
            System.out.println(new String(b,0,len));
        }

        socket.close();

    }
}
