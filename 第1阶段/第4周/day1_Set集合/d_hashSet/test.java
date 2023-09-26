package week4.day1_Set.d_hashSet;

import java.util.HashSet;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(11);
        set.add(44);
        set.add(22);
        set.add(66);
        set.add(22);
        System.out.println(set);//HashSet特点：无序、唯一

        //循环遍历：无下标，for无法使用
        for (int i = 0; i < set.size(); i++) {

        }

        //增强for：本质就是迭代器
        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
