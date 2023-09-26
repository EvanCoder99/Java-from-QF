package week3.day4;

import java.math.BigDecimal;
import java.util.Scanner;

public class yawHomeWork {
    public static void main(String[] args) {
        //1、编写程序检查“hello” 是否包含e
        String s1 = "hello";
        System.out.println(s1.contains("e")?"包含":"不包含");

        //2、编写程序去除“      ha he    ”的前后空格
        System.out.println("      ha he    ".trim());

        //3、编写程序将 “hello” 全部变为大写,并输出到屏幕,截取子串”LLO” 并输出到屏幕
        String s3 = "hello";
        System.out.println("hello转为大写："+s3.toUpperCase());
        System.out.println("截取子串LLO："+s3.toUpperCase().substring(2));

        //4、String s = "富家不用买良田，书中自有千钟粟。安居不用架高堂，书中自有黄金屋。出门莫恨无人随，书中车马多如簇。娶妻莫恨无良媒，书中自有颜如玉。男儿欲遂平生志，五经勤向窗前读。"
        //请分段输出诗句，按'。,'分段即可
        //提示:如果按照,和。拆分，需要写成[,。]
        String s =  "富家不用买良田，书中自有千钟粟。" +
                    "安居不用架高堂，书中自有黄金屋。" +
                    "出门莫恨无人随，书中车马多如簇。" +
                    "娶妻莫恨无良媒，书中自有颜如玉。" +
                    "男儿欲遂平生志，五经勤向窗前读。";
        System.out.println(s.replaceAll("[，。]","\n"));


        //5、倒叙输出字符串“abcdefg”两种方式：StringBuilder， toCharArray
        StringBuffer sb = new StringBuffer("abcdefg");
        System.out.println("abcdefg通过reverse()倒序输出："+sb.reverse());
        String s5 = "abcdefg";  //将字符串转换为字符数组
        char[] c = new char[s5.toCharArray().length];
        System.out.print("abcdefg通过toCharArray()倒序输出：");
        for (int i = s5.toCharArray().length-1; i >= 0 ; i--) {
            c[i] = s5.toCharArray()[i];
            System.out.print(c[i]);
        }


        //6、使用BigDecimal做加、减、乘、除计算
        BigDecimal df = new BigDecimal("0.1");
        System.out.println(df.add(new BigDecimal("0.09")));
        System.out.println(df.subtract(new BigDecimal("0.09")));
        System.out.println(df.multiply(new BigDecimal("0.09")));
        //ArithmeticException:当除不尽，则会出现算数异常；需要保留小数位
        //参数1：BigDecimal对象  参数2：保留位数-int 参数3：四舍五入或其它模式-状态值int
         //ROUND_HALF_UP:四十五入    BigDecimal.ROUND_FLOOR：截断多余位数
        System.out.println(df.divide(new BigDecimal("0.09"),2,BigDecimal.ROUND_HALF_UP));
        System.out.println(df.divide(new BigDecimal("0.09"),2,BigDecimal.ROUND_FLOOR));


        //7、输入一个字符串，输入要查找的字符，求出查找特定字符出现的次数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String s7 =  sc.next();
        System.out.println("输入查找的字符：");
        char c7 = sc.next().charAt(0);
        System.out.println("出现的次数为："+find(s7,c7));


    }
    public static int find(String s,char c){
        char[] temp = s.toCharArray();  //把字符串转换为char数组
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == c)
                count++;
        }
        return count;
    }
}
