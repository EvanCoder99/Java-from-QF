package week5.day3_Net.c_manyClient;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5555);
        Socket socket = null;
        while (true){   //
            socket = ss.accept();
            new ServerThread(socket).start();
        }
    }
}
