package day3_JDBC.practics;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class receive {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(10086);

//2、接收数据包
        byte[] b = new byte[1024];	//使用字节数组接收数据
        DatagramPacket dp = new DatagramPacket(b,b.length);
        ds.receive(dp);//阻塞方法，会等待发送端发送消息

//3、解析数据
        byte[] data = dp.getData();
        int len = dp.getLength();
        String ip = dp.getAddress().getHostAddress();//dp.getAddress().getHostAddress()
        String name = dp.getAddress().getHostName();//主机名
        int port = dp.getPort();

        System.out.println("接收到数据："+ new String(data,0,len));
        System.out.println("该数据是从"+ip+"，名为"+name+"电脑中的"+port+"端口发出的");

//4、释放资源
        ds.close();
    }
}
