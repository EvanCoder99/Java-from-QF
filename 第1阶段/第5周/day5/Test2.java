package week5.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("lhp");
        list.add("fengjie");
        list.add("liudehua");
        list.add("gdg");
        list.add("zhaobs");

        List<String> l1 = getStartL(list); //获取出以l开头的元素
        System.out.println(l1);

        List<String> l2 = getLength(list); //获取出以l开头的元素
        System.out.println(l2);

        //使用断言型处理： 传参lambda--维护性更强
        //Predicate<String> pre = s->s.startsWith("l")
        List<String> l3 = getList(list, s -> s.startsWith("l"));
        System.out.println("l开头：" + l3);

        //Predicate<String> pre = s->s.length()>5
        List<String> l4 = getList(list, s -> s.length() > 5);
        System.out.println("长度大于5：" + l4);
    }

    private static List<String> getList(List<String> list, Predicate<String> pre) {
        List<String> l = new ArrayList<String>();
        for (String a : list) {
            if (pre.test(a)) {
                l.add(a);
            }
        }
        return l;
    }

    private static List<String> getLength(List<String> list) {
        List<String> l = new ArrayList<String>();
        for (String a : list) {
            if (a.length() > 5) {    //将list集合中的元素依次放入a，因为s->s.length()>5，参数是String s，然后test(a)又是list集合的String元素，故test()方法测试a的长度是否大于5
                l.add(a);
            }
        }
        return l;
    }

    private static List<String> getStartL(List<String> list) {
        List<String> l = new ArrayList<String>();
        for (String a : list) {
            if (a.startsWith("l")) { //将list集合中的元素依次放入a，因为s->s.startWith("l")，参数是String s，然后test(a)又是list集合的String元素，故test()方法测试a是否是以l开头
                l.add(a);
            }
        }
        return l;
    }
}
