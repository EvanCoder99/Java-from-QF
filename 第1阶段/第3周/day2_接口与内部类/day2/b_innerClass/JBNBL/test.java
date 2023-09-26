package week3.day2.b_innerClass.JBNBL;

import java.sql.SQLOutput;

public class test {
    public static void main(String[] args) {
        new Outer().show();
    }
}
class Outer{
    public void show() {
        int[] a = {1,2,3};
        a[0] = 10;
        String name = "张三";

        class Inner{
            public void test() {
//                a[0] = 99;
//                name = "李四";
                System.out.println(a[0]);
//                System.out.println(name);
            }
        }
        new Inner().test();
    }
}