package week5.day1_IOStream.b_ByteIO;

import javax.naming.Name;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class test1 {
    public static void main(String[] args) {
        //字节流分为输入流和输出流：
        //输入流提供了读和关闭方法；输出流提供了写和关闭方法
        //注意在项目中操作IO流，往往都是捕获；后续为了方便演讲，则使用抛出\
        OutputStream os = null;
        try {
            os = new FileOutputStream("a.txt");//实例化输出流，指定存文件名，没有加盘符，说明是当前工程下的文件

            os.write("hello word".getBytes());//String-->byte[]

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//            if (os != null) {
//                try {
//                    os.close();//读写数据一定要记得关闭资源，否则容易出现问题
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            Utils_forFile.closeAll(os);//重载，传几个关几个；读写数据一定要记得关闭资源，否则容易出现问题
        }
    }
}
