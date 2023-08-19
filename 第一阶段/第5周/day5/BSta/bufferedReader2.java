package week5.day5.BSta;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class bufferedReader2 {
    public static void main(String[] args) throws Exception {
        //1、字节流
        FileInputStream fis = new FileInputStream("e:/a.txt");

        //2、转换流，将字节流转换为字符流
        //fis是节点流，isr是包装流
        InputStreamReader isr = new InputStreamReader(fis);

        //3、字符缓冲流
        //isr是节点流，br是包装流
        BufferedReader br = new BufferedReader(isr);

        //1-3合并
        BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream("e:/a.txt")));

        //读文件信息
        String len = null;
        while ((len = br.readLine()) != null)
            System.out.println(len);
        //关闭最外层
        br.close();
    }
}
