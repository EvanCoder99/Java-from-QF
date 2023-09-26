package week5.day3_Net.c_manyClient;

import week5.day3_Net.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{
    public Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        InputStream is = null;
        BufferedReader br = null;
        try {
            is = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while (true){
                String msg = br.readLine();
                System.out.println(msg);
                if (msg.equals("886")){
                    System.out.println("已退出");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            Utils.closeAll(is,br,socket);
        }

    }
}
