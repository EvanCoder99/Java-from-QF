package week5.day2_File_Net.dayWork;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class test4 {
    public static void main(String[] args) {
        //4.使用FileNameFilter接口完成后缀为txt文件的查找
        File file = new File("a/b");
        File[] fs = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("txt");
            }
        });
        System.out.println(Arrays.toString(fs));
    }
}
