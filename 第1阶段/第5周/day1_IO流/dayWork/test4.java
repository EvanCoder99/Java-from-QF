package week5.day1_IOStream.dayWork;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class test4 {
    //4.使用字符节点流进行文件的读取和写出
    @Test
    public void outTest() throws Exception {
        FileWriter fw = new FileWriter("work4.txt");
        fw.write("字符节点流进行文件的写入");
        fw.close();
    }
    @Test
    public void inTest() throws Exception {
        FileReader fr = new FileReader("work4.txt");
        char[] c = new char[1024];
        int len = fr.read(c);
        System.out.println(new String(c,0,len));
        fr.close();
    }
}
