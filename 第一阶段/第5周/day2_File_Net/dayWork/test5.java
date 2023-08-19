package week5.day2_File_Net.dayWork;

import java.io.File;

public class test5 {
    public static void main(String[] args) {
        //5.删除指定目录，注意，非空目录不能直接删除，需要先将文件删除后，才能删除空目录--使用递归删除
        delete(new File("a"));
    }
    private static void delete(File file){
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isFile()){ //如果是文件
                if (f.delete())
                    System.out.println(f.getName()+"文件删除成功");
            }else {  //如果是目录，则继续递归
                delete(f);
                System.out.println(f.getName()+"文件删除成功");
            }
        }
        file.delete();//删完文件后，所有文件夹都为空，才能删除目录
    }
}
