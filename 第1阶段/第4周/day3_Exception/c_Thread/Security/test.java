package week4.day3_Exception.c_Thread.Security;

import java.util.Arrays;

//模拟ArrayList集合在多线程中的不安全性
//问题：通过睡眠可以复现出问题
class MyList{
    String[] a = {null,null};
    int index = 0;
    public void add(String value) {
        a[index] = value;
        try {
            Thread.sleep(8);//放大镜，复现问题
        } catch (InterruptedException e) {}
        index++;
    }
}
public class test {
    public static void main(String[] args) {
        MyList list = new MyList();
        new Thread(new Runnable() {
            @Override
            public void run() {
                list.add("ddd");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                list.add("ccc");
            }
        }).start();



        System.out.println(Arrays.toString(list.a));
    }
}
