package week3.day4.e_Data;

import java.util.Date;

public class Data {
    public static void main(String[] args) {
        //直接实例化对象，即可获取当前日期的类，以格林威治时间格式显示
        Date d = new Date();
        System.out.println("格林威治时间格式："+d);

        System.out.println("从1970年到现在的毫秒值："+d.getTime());
        System.out.println(new Date(1000));//1970+1
        System.out.println(new Date(d.getTime()));//1970+1970到现在的时间的毫秒值=今天
    }
}
