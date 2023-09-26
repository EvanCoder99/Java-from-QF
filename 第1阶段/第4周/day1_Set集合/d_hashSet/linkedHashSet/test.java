package week4.day1_Set.d_hashSet.linkedHashSet;

import java.util.LinkedHashSet;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        //有序、唯一
        Set<Integer> set = new LinkedHashSet<>();
        set.add(1);
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(3);
        System.out.println(set);
    }
}
