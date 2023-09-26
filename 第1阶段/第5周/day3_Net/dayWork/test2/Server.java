package week5.day3_Net.dayWork.test2;

import week5.day3_Net.Utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//2.使用socket完成,客户端发送信息,服务器接收信息(使用字符缓冲流收发数据)
public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务器，指定端口
        ServerSocket ss = new ServerSocket(6666);
        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String msg = br.readLine();
        System.out.println(msg);

        Utils.closeAll(is,br,socket);
    }

}
