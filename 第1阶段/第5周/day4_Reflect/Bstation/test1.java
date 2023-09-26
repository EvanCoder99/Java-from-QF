package week5.day4_Reflect.Bstation;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test1 {
    public static void main(String[] args)  {
        //1、创建一个文件字节输入流对象，用于读取文件
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("e:/a.txt");
            //2、读取字节，并用byte[]数组接收
            int len;
            byte[] b = new byte[4];
            while ((len = fis.read(b)) != -1){  //没有读到末尾，继续循环
                System.out.println(new String(b,0,len));   //将字节数组全部转换为字符串
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FileOutputStream fos = null;
        try {
            //文件不存在则会新建，且会将原文件清空后再写入
//            fos = new FileOutputStream("e:/a.txt");
            fos = new FileOutputStream("e:/a.txt",true);//向后追加
            fos.write(97);

            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
}
