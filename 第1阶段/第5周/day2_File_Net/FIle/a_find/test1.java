package week5.day2_File_Net.FIle.a_find;

import java.io.File;
import java.io.IOException;

public class test1 {
    public static void main(String[] args) throws IOException {
        File file = new File("a\\b\\a.txt\\c.txt");
//        File file = new File("a/b/a.txt");

        File parent = file.getParentFile();
        if (parent!=null && !parent.exists()){
            if (parent.mkdirs()){
                System.out.println("创建目录成功");
            }
        }
        if (!file.exists()){
            if (file.createNewFile()){
                System.out.println("创建文件成功");
            }
        }
    }
}
