package week5.day1_IOStream.dayWork;

import org.junit.Test;
import week5.day1_IOStream.b_ByteIO.Utils_forFile;

import java.io.*;
import java.util.Scanner;

public class test1 {
    //1.使用FileInputStream读取文件,修改文字,在使用FileOutputStream输出修改文件
    @Test
    public void outTest() throws Exception {
        OutputStream os = new FileOutputStream("work.txt");
        os.write("要修改的文字".getBytes());   //String转byte[]
        if (os != null) {
            try {
                os.close();//读写数据一定要记得关闭资源，否则容易出现问题
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        InputStream is = null;
        try {
            is = new FileInputStream("work.txt");
            byte[] b = new byte[1024];
            int len = is.read(b);
            while (len!=-1){
                System.out.print("原内容：");
                System.out.println(new String(b,0,len));//参数1：转数据的字节数组  参数2：转的下标-0  参数3：转的长度
                System.out.print("新内容：");
                b = "修改完的文字".getBytes();
                System.out.println(new String(b,0,len));
                len = is.read(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils_forFile.closeAll(is);
        }

    }

    @Test
    public void inTest() throws Exception {

    }
}
