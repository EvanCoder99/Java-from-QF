package week4.day5_ThreadHigh.b_safeList.safeSet;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class test3 {
    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();
        set.add("zs");
        set.add("ls");
        set.add("ww");
        System.out.println(set);
    }
}
