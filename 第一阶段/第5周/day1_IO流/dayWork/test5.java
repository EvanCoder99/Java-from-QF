package week5.day1_IOStream.dayWork;

import org.junit.Test;

import java.io.*;

public class test5 {
    //5.使用字符转换流设置编码格式进行文件读取和写出
    @Test
    public void outTest() throws Exception {
       OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("work5.txt"),"UTF-8");
       osw.write("使用字符转换流");    //写入文件
        osw.close();
    }
    @Test
    public void inTest() throws Exception {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("work5.txt"),"UTF-8");
        char[] c = new char[1024];
        int len = isr.read(c);
        System.out.println(new String(c,0,len));
        isr.close();
    }
}
