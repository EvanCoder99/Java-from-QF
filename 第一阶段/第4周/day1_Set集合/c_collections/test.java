package week4.day1_Set.c_collections;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Collections 集合工具类，提供了一些除集合存取以外的方法
public class test {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(5);
        l.add(1);
        l.add(2);
        Collections.sort(l);    //排序
        System.out.println(l);

        Collections.reverse(l);//集合元素翻转
        System.out.println(l);

    }
}
