package week5.day6;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class test1  {
    public static void main(String[] args) {
        File file = new File("a");
        //方式一：
        /*
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isFile() && f.getName().endsWith("txt"))
                System.out.println(f);
        }*/

        //方式二：
        File[] f = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith("txt");
            }
        });
        System.out.println(Arrays.toString(f));
    }
}
