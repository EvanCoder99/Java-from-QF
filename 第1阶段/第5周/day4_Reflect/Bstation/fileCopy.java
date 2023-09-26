package week5.day4_Reflect.Bstation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class fileCopy {
    public static void main(String[] args) {
        //文件的拷贝：将当前工程的a.txt拷贝到d:\b.txt
        //分析：先将a.txt的资源循环读取，并写到b.txt
        FileInputStream fis=null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("e:/a.txt");
            fos = new FileOutputStream("f:/b.txt");
            int len;
            byte[] b = new byte[5];
            while ((len = fis.read(b)) != -1){
                fos.write(b,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null || fis != null){
                try {
                    fos.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
