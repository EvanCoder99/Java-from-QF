package week5.day2_File_Net.dayWork;

import java.io.File;
import java.io.IOException;

public class test3 {
    public static void main(String[] args) throws Exception {
        //3.使用File创建文件/文件夹
        File file = new File("a\\b\\c.txt");
        File parent = file.getParentFile();
        if (parent!=null && !parent.exists()){  //创建目录
            if (parent.mkdirs())
                System.out.println("目录创建成功");
        }
        if (!file.exists()){    //创建文件
            if (file.createNewFile())
                System.out.println("创建成功");
        }
    }
}
