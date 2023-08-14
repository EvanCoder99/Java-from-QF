package week5.day1_IOStream.c_buffer;

import org.junit.Test;
import week5.day1_IOStream.b_ByteIO.Utils_forFile;

import java.io.*;

public class test1 {
    @Test
    public void outTest() throws IOException {
        //字节缓冲流：
        // 里面带了缓冲区，存取数据都需要先经过缓冲区：
        //缓冲区满或刷新缓冲区，内容才会到磁盘文件
        //好处：减少了与磁盘交互次数，提升了性能
        //内部提供的缓冲区大小为892个（恒定值）字节，如果未超出范围，都在缓冲区中
        //设计模式：装饰者模式，针对组织结构的设计
        //传入一个对象，最终包装成另外一个对象
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("a.text"));
        bos.write("helloword....缓冲流".getBytes());
        Utils_forFile.closeAll(bos);
    }

    @Test
    public void inTest() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.text"));
        byte[] b = new byte[1024];
        int len = bis.read(b);
        System.out.println(new String(b,0,len));

    }


}
