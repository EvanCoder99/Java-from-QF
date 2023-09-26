package week5.day3_Net.b_upload;

import week5.day3_Net.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端Socket对象，指定服务器的Ip和端口
        Socket socket = new Socket("127.0.0.1", 7777);

        //客户端从本地读图片，再写到socket
        InputStream is = new FileInputStream("c.jpg");
        int len;
        byte[] b = new byte[1024];
        OutputStream os = socket.getOutputStream();
        while ((len=is.read(b)) != -1){
            os.write(b,0,len);
        }
        System.out.println("上传成功");
        Utils.closeAll(is,os,socket);
    }
}
