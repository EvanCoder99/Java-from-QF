package week5.day3_Net.dayWork.test2;

import week5.day3_Net.Utils;

import java.io.*;
import java.net.Socket;

//2.使用socket完成,客户端发送信息,服务器接收信息(使用字符缓冲流收发数据)
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6666);

        //客户端发送数据
        OutputStream os = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

        //客户端接收数据
        bw.write("客户端发送消息...");
        bw.newLine();
        bw.flush();

        Utils.closeAll(os,bw,socket);


    }
}
