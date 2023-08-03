package week3.day4.e_Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Simpledateformat {
    public static void main(String[] args) throws ParseException {
        //SimpleDateFormat日期格式类： 可以将Date提供的日期，进行转格式
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(s.format(new Date())); ////传入Date对象，返回日期的字符串格式，date-->Stirng

        //已知字符串的日期，转Date对象
        String a = "2023-08-03 17:17:46";
        System.out.println(s.parse(a));


    }
}
