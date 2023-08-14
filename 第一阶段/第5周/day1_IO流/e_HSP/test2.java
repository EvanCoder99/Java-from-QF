package week5.day1_IOStream.e_HSP;

import org.junit.Test;

import java.io.File;

public class test2 {
    //获取文件信息
    @Test
    public void info(){
        //1、先创建文件对象
        File file = new File("e:\\new1.txt");

        //2、调用相应方法，得到对应信息
        System.out.println("文件名："+file.getName());
        System.out.println("文件绝对路径："+file.getAbsolutePath());
        System.out.println("得到文件父目录："+file.getParentFile());
        System.out.println("文件大小（字节）："+file.length());//new袁阿文=1+1+1+3+3+3（UTF-8汉字占3字节）
        System.out.println("文件是否存在："+file.exists());
        System.out.println("是否为一个文件："+file.isFile());
        System.out.println("是否为一个目录："+file.isDirectory());

    }
}
