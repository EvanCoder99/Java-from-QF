package week5.day5.dayWorl;

import java.util.ArrayList;
import java.util.List;

public class test1 {
    public static void main(String[] args) {
       /* 1.应用案例: 集合存储字符串元素,例如: "Ldh","guodegang","lyf","Gyy","liuyifei"
        1.找出集合中包含y的元素; 2. 找出集合中含有大写字母的元素
        方式1：使用常规的集合操作求出----循环遍历后判定
        方式2：使用lambda表达式来操作----提示：断言型接口*/


        List<String> list = new ArrayList<>();
        list.add("Ldh");
        list.add("guodegang");
        list.add("lyf");
        list.add("Gyy");
        list.add("liuyifei");
        System.out.println(list);

        //方式一：
        System.out.println("循环遍历list集合：");
        for (String s : list) {
            if (s.contains("y"))
                System.out.println(s);
        }

        //方式二：
        System.out.println("\nlambda表达式，找出集合中包含y的元素：");
        list.stream().filter(s->s.contains("y")).forEach(System.out::println);
        System.out.println("\nlambda表达式，找出集合中包含大写的元素：");
        list.stream().filter(s->s.matches(".*[A-Z].*")).forEach(System.out::println);

    }
}
