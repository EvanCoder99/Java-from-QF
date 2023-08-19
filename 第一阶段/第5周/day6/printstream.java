package week5.day6;

import javax.sound.midi.Soundbank;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class printstream {
    public static void main(String[] args) throws Exception {
        //合起来写
        System.out.println("hello，world");

        //分开写
        PrintStream ps = System.out;
        ps.println("hello tom");
        ps.println(3.14);
        ps.print(true);

        //可以改变输出方向，不再指向控制台，指向"a.txt"文件
        PrintStream ps2 = new PrintStream("e:/a.txt");
        //修改输出方向，将输出方向修改到"a.txt"文件
        System.setOut(ps2);
        ps2.println("hello tom");
        ps2.println(3.14);
        ps2.print(true);

        //标准输出流不需要手动close()关闭，
    }
}
