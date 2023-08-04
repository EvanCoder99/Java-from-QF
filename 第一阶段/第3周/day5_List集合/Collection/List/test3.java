package week3.day5.Collection.List;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class test3 {
    public static void main(String[] args) {
        //List循环遍历
        List l = new ArrayList();
        l.add(1);
        l.add(3);
        l.add(2);

        //基本for循环
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
        System.out.println("---------");
        //增强for循环：右边集合，左边从集合中提取元素，因为add里面任意的引用类型都可，所以用父类接受
        for (Object o :
                l) {
            System.out.println(o);
        }

        System.out.println("----迭代器-----");
        ListIterator li = l.listIterator();//有迭代器功能和反向遍历
        while (li.hasNext()){//判断是否有一下个元素
            System.out.println(li.next());
        }

        System.out.println("----------");
        while (li.hasPrevious()){ //判断是否有上一个（在迭代器指向最后，才能用）
            System.out.println(li.previous());//取出后，指向上一个
        }
    }
}
