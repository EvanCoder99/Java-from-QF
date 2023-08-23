package day1_Plane;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("lhp");
        list.add("fengjie");
        list.add("liudehua");
        list.add("gdg");
        list.add("zhaobs");

        //传统方式，一个功能一个方法
        List<String> l1 = getStratL(list);
        System.out.println(l1);
        List<String> l2 = getlength(list);
        System.out.println(l2);

        List<String> l3 = getList(list, s -> s.startsWith("l"));
        List<String> l4 = getList(list, s -> s.length() > 5);

    }
    public static List<String> getList(List<String> list, Predicate<String> pre){
        List<String> l = new ArrayList<>();
        for (String s : l) {
            // @Override
            //    public boolean test(String s) {
            //        return s.endsWith("llo");
            //    }
            if (pre.test(s))
                l.add(s);
        }
        return l;
    }

    public static List<String> getStratL(List<String> list){
        List<String> l = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("l"))
                l.add(s);
        }
        return l;
    }
    public static List<String> getlength(List<String> list){
        List<String> l = new ArrayList<>();
        for (String s : list) {
            if (s.length() > 5)
                l.add(s);
        }
        return l;
    }
}
