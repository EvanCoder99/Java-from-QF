package week5.day2_File_Net.dayWork;

import java.io.File;

public class test2 {
    public static void main(String[] args) {
        //2.使用File,输出文件的父路径,绝对路径，文件名，长度等
        File file = new File("a/a.txt");
        System.out.println("文件的父路径："+file.getParentFile());
        System.out.println("文件的绝对路径："+file.getAbsolutePath());
        System.out.println("文件名："+file.getName());
        System.out.println("文件的长度："+file.length());
    }
}
