package week5.day2_File_Net.dayWork;

import org.junit.Test;

import java.io.*;

public class test1 {
    //1.将字节流转换为字符缓冲流，并进行换行读写内容
    @Test
    public void buffetTest() throws Exception {
        OutputStream os = new FileOutputStream("work1.txt");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write("第一题....");
        bw.newLine();
        bw.write("换行....");
        bw.close();
    }
}
