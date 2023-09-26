package week5.day5.weekTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test1 {
    public static void main(String[] args) {
        //一、	请选择合适的流，实现一个二进制文件的拷贝功能，例如将d:\\io.exe拷贝到e:\\io.exe
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("e:/a.txt");
            fos = new FileOutputStream("f:/t.txt");
            int len = 0;
            byte[] b = new byte[1024];
            while ((len = fis.read(b)) != -1){
                fos.write(b,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis != null)
                    fis.close();
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
