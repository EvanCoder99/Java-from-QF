package week3.day5.Collection.List;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class test {
    public static void main(String[] args) {
        //Connection循环遍历
        Collection c = new ArrayList();
        c.add(1);
        c.add(3);
        c.add(2);
        //size是集合的长度，基本for循环操作下标的方式不可以，集合无下标
        for (int i = 0; i < c.size(); i++) {
            //c.没有下标操作
        }

        //1、增强for循环：右边集合，左边从集合中提取元素，因为add里面任意的引用类型都可，所以用父类接受
        for (Object o : c) {
            System.out.println(o);
        }
        System.out.println("===========");
        //迭代器循环遍历
        Iterator it = c.iterator();
        //判断it有无下一个元素
        while (it.hasNext()){
            System.out.println(it.next());//取出下一个（之后next()会移位到下一个）打印
        }
    }
}
