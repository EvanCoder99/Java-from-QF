package week5.day6;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class findfile1 {
    public static void main(String[] args) {
        File file = new File("a");


        /*//方式一：
        File[] f_arry = file.listFiles();
        for (File f : f_arry) {
            if (f.isFile() && f.getName().endsWith("txt"))
                System.out.println(f);
        }*/

        //方式二：FileFilter接口
        File[] f_arry2 = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                System.out.println("pathname当前文件夹和子目录："+pathname);
                return pathname.isFile() && pathname.getName().endsWith("txt");
            }
        });
        //返回true数组就接收当前文件夹下的同一级目录，fasle就没有
        //但不不符题意，所以要增加判断条件
        System.out.println(Arrays.toString(f_arry2));

        //方式三：FileNameFilter接口
        /*File[] f_arry3 = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                //dir就是父级目录a，name是子级目录b文件夹、c.txt文件夹、a.txt
                File src = new File(dir, name);
                System.out.println(src);
                return src.isFile() && name.endsWith("txt");
            }
        });
        System.out.println(Arrays.toString(f_arry3));*/
    }
}
