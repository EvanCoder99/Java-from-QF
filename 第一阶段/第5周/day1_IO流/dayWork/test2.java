package week5.day1_IOStream.dayWork;

import org.junit.Test;
import week5.day1_IOStream.b_ByteIO.Utils_forFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class test2 {
    public static void main(String[] args) throws Exception {
        //2.使用FileInputStream复制图片
        FileInputStream fis = new FileInputStream("E:\\image.jpg");

        FileOutputStream fos = new FileOutputStream("F:\\image.jpg");
        byte[] b = new byte[1024];
        int len = fis.read(b);
        while (len != -1){
            fos.write(b,0,len);
            len = fis.read(b);
        }
        Utils_forFile.closeAll(fis,fos);
    }
}
