package week3.day5.Collection.List;


import java.util.ArrayList;
import java.util.List;

public class test2 {
    //List的基本操作、存储特点
    public static void main(String[] args) {
        List l = new ArrayList();
        l.add(1);
        l.add(5);
        l.add(7);
        l.add(1);
        System.out.println(l);

        l.add(1,666);//指定位置添加元素
        System.out.println(l);

        List l2 = new ArrayList();
        l2.add(777);
        l.addAll(1,l2);//指定位置存集合
        System.out.println(l);

        System.out.println(l.get(1));//根据下标取元素
        l.set(2,0);//指定位置修改元素
        System.out.println(l);
    }
}
