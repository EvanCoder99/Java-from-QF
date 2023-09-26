package week4.day1_Set.TreeSet;

import java.util.Set;
import java.util.TreeSet;

public class test {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(2);
        System.out.println(set);    //[1, 2, 3],可排序，唯一

        //循环遍历：1、无下标，用不了
        for (int i = 0; i < set.size(); i++) {

        }
        //2、增强for
        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
