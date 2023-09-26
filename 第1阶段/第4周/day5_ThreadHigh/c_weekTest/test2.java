package week4.day5_ThreadHigh.c_weekTest;

import java.util.HashSet;
import java.util.Set;

public class test2 {
    public static void main(String[] args) {
        //2. 如何判断两个HashSet集合是否有交集，并打印出他们的交集
        Set<String> set1 = new HashSet<>();
        set1.add("1");
        set1.add("2");
        set1.add("3");
        Set<String> set2 = new HashSet<>();
        set2.add("4");
        set2.add("2");
        set2.add("5");
        Set<String> result = new HashSet<>();
        for (String i : set1) {
            for (String j : set2) {
                if (j.equals(i))
                    result.add(i);
            }
        }
        System.out.println("交集："+result);
    }
}
