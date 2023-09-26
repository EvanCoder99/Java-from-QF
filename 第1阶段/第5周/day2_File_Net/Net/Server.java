package week5.day2_File_Net.Net;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("监听9999端口");
         ss.accept();
    }
}
