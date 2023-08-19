package week5.day3_Net.d_register;

import week5.day3_Net.Utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        //接收数据
        String msg = br.readLine();//id:1,name:zs,pwd:123,age:55
        //拆封字符串
        String ids = msg.split(",")[0];//id:1
        String id = ids.split(":")[1];//1
        Properties p = new Properties();
        p.load(new FileInputStream("Test6/src/user.properties"));

        OutputStream os = socket.getOutputStream();
        if (p.contains(id)){
            os.write("已成功".getBytes());
        }else{
            os.write("注册成功".getBytes());
            p.put(id,msg);
            p.store(new FileOutputStream("Test6/src/user.properties"),"");
        }
        Utils.closeAll(is,os,br,socket);
    }
}
