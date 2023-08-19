package week5.day3_Net.c_manyClient;

import week5.day3_Net.Utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建一个客户端，只需要运行多次，模拟多个客户端
        Socket socket = new Socket("127.0.0.1", 5555);
        System.out.println("客户端输入数据：");
        Scanner sc = new Scanner(System.in);

        OutputStream os = socket.getOutputStream();//socket的字节流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));//封装成字符缓冲流
        while (true){
            String msg = sc.next();
            bw.write(msg);
            bw.newLine();
            bw.flush();
            if (msg.equals("886")){
                System.out.println("已退出");
                break;
            }
        }
        Utils.closeAll(bw,os,socket);

    }

}
