package week5.day1_IOStream.e_HSP;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class test1 {
    public static void main(String[] args) {


    }
    //方式一：
    @Test
    public void creat1(){
        String filePath = "E:\\new1.txt";
        File file = new File(filePath);//填入路径，创建文件对象；此时只是有文件对象，文件并没有创建
        try {
            file.createNewFile();//真正创建文件
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void creat2(){
        File parent = new File("e:\\");
        String child = "new2.txt";
        File file = new File(parent, child);//只创建文件对象，还未创建文件
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void creat3(){
        String parent = "e:\\";
        String child = "new3.txt";
        File file = new File(parent, child);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
