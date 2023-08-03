package week3.day4.e_Data;

import java.util.Calendar;

public class calendar {
    public static void main(String[] args) {
        //Calendar类:日历类(抽象类)，可用于求日期的类，年，月，日等等
        Calendar c = Calendar.getInstance();//通过静态方法返回子类对象c
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH)+1);//获取月(0-11)，需要+1
        System.out.println(c.get(Calendar.DATE));

        c.set(Calendar.YEAR,2000);//年设置为2000
        System.out.println(c.get(Calendar.YEAR));

        c.add(Calendar.YEAR,5);//在原来的基础上+5年
        System.out.println(c.get(Calendar.YEAR));

    }
}
class a{}