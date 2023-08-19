package week5.day2_File_Net.HSP;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Fileinputstream {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("e:/a.txt");//创建一个FileInputStream对象，用于读取文件
            //读取方式一：
            /*while (true) {
                int len = fis.read();//从该输入流读取一个字节本身的数据；到达末尾返回-1
                if (len == -1)
                    break;
                System.out.println(len);
            }*/
            //读取方式二：
            /*int len = fis.read();
            while (len != -1){
                System.out.println(len);
                len = fis.read();
            }*/
            //读取方式三：
//            int len = 0;
//            while ((len = fis.read()) != -1)
//                System.out.println(len);

            /*以上三种方式都是一次读取一个字节byte，这样内存和硬盘交互太频繁，时间与资源都耗费在交互上面了
            * 能否一次读取多个字节？
            *
            * */
            byte[] b = new byte[4];



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.closeAll(fis);
        }
    }
}
