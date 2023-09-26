package week5.day5.BSta;

import java.io.*;

public class bufferedWriter {
    public static void main(String[] args) throws IOException {
        //1、文件字符流
        FileWriter fw = new FileWriter("e:/a.txt",true);
        //带缓冲区的字符流
        BufferedWriter bw = new BufferedWriter(fw);

        //将文件字节流 通过 字节转换流 转成字符流
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("e:/a.txt")));

        bw.write("\n我是中国人");

        bw.flush();
        bw.close();
    }
}
