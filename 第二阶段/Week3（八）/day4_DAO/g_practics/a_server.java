package day4_DAO.g_practics;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class a_server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);

        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();
//        //字符转换流，防止汉字乱码
//        InputStreamReader isr = new InputStreamReader(is);

        byte[] b = new byte[1024];
        int len = 0;
        while ((len = is.read(b)) != -1){
            System.out.println(new String(b,0,len));
        }


        socket.close();
        ss.close();
    }
}
