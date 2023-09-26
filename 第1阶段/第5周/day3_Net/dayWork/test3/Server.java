package week5.day3_Net.dayWork.test3;

import week5.day3_Net.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//3.实现客户端从服务器中下载图片功能（类似上传图片）
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        Socket socket = ss.accept();

        //服务器从本地读取资源
        InputStream is = new FileInputStream("c.jpg");
        OutputStream os = socket.getOutputStream();
        int len;
        byte[] b = new byte[1024];
        while ((len=is.read(b)) != -1){
            os.write(b,0,len);
        }

        Utils.closeAll(os,is,socket);
    }
}
