package week5.day6;

import java.io.File;

public class delete {
    public static void main(String[] args) {
        File file = new File("a");
        fun(file);

    }
    public static void fun(File file){
        //获取a文件的下一级目录
        File[] fs = file.listFiles();

        //1、先删除文件夹里面所有的内容
        for (File f : fs) {
            if (f.isDirectory())
                fun(f); //文件夹就递归
            else
                f.delete(); //文件就直接删除
        }

        //2、再删除自己
        file.delete();
    }
}
