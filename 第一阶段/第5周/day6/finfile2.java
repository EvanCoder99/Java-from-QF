package week5.day6;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class finfile2 {
    public static void main(String[] args) throws IOException {
        find(new File("a"));

    }
    public static void find(File dir){

        //方式一：listFiles()
        File[] fs1 = dir.listFiles();
        for (File file : fs1) {
            if (file.isFile() && file.getName().endsWith("txt"))
                System.out.println(file);
            else
                find(file);
        }


    }
}
