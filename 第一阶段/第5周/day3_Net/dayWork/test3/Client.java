package week5.day3_Net.dayWork.test3;

import week5.day3_Net.Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//3.实现客户端从服务器中下载图片功能（类似上传图片）
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6666);
        InputStream is = socket.getInputStream();
        byte[] b = new byte[1024];
        int len;
        OutputStream os = new FileOutputStream("c.jpg");
        while ((len=is.read()) != -1)
            os.write(b,0,len);
        System.out.println("下载成功");
        Utils.closeAll(os,is,socket);
    }
}
