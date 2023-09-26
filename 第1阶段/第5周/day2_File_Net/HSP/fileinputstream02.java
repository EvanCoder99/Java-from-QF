package week5.day2_File_Net.HSP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class fileinputstream02 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
//            fos = new FileOutputStream("e:/c.txt");//文件不存在会新建，且会将原文件内容清空后，再写入（谨慎使用）
            fos = new FileOutputStream("e:/c.txt", true);//向后追加写入，true为在文件末尾写入，false为文件开始处写入
            byte[] b = {97, 98, 99, 100};
            fos.write(b);   //abcd
            fos.write(b, 0, 2);   //ab

            fos.flush();//写完之后一定要刷新
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
