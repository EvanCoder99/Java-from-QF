package week5.day6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    public static void log(String msg) {
        PrintStream ps = null;
        try {
            //标准输出流指向一个日志文件
            ps = new PrintStream(new FileOutputStream("e:/a.txt",true));
            //改变输出方向
            System.setOut(ps);
            //获取系统当前时间，格式化
            Date nowTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss sss");
            String strTime = sdf.format(nowTime);

            System.out.println(strTime+" : " +msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
