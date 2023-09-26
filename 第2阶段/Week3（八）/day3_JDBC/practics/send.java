package day3_JDBC.practics;

import java.net.*;

public class send {
    public static void main(String[] args) throws Exception {
        //1、创建DatagramSocket对象（快递公司）
        //空参构造：在所有可用的端口中随机一个进行使用
        //有参构造：指定端口号进行绑定，往外发送数据
        DatagramSocket ds = new DatagramSocket();

//2、打包数据
        String str = "这是UDP协议";
        byte[] b = str.getBytes();//数据使用字节数组发送，DatagramPacket()的参数
        InetAddress address = InetAddress.getByName("127.0.0.1");//获取发送的地址
        int port = 10086;

        DatagramPacket dp = new DatagramPacket(b, b.length, address, port);

//3、发送数据
        ds.send(dp);

//4、释放资源
        ds.close();
    }
}
