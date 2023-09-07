package day4_DAO.g_practics;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class a_client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 10086);
        Scanner sc = new Scanner(System.in);
        OutputStream os = socket.getOutputStream();
        while (true) {
            System.out.println("请输入要发送的数据：");
            String date = sc. next();
            os.write(date.getBytes());

            if ("886".equals(date))
                break;
        }
        socket.close();
    }
}
