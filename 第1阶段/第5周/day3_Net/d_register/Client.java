package week5.day3_Net.d_register;

import week5.day3_Net.Utils;

import javax.sound.sampled.Port;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream os = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

        String msg = getInfo();
        bw.write(msg);  //id: name: pwd:
        bw.newLine();
        bw.flush();

        InputStream is = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = is.read(b);
        System.out.println(new String(b,0,len));
        Utils.closeAll(os,is,bw,socket);
    }

    private static String getInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要注册的信息：");
        System.out.print("ID:");
        String id = sc.next();
        System.out.print("name:");
        String name = sc.next();
        System.out.print("pwd:");
        String pwd = sc.next();
        System.out.print("age:");
        String age = sc.next();
        return "ID:"+id+" name:"+name+" pwd:"+pwd+" age:"+age;
    }
}
