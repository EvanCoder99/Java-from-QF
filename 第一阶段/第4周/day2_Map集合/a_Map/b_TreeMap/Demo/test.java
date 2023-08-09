package week4.day2_Map_Excep.a_Map.b_TreeMap.Demo;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        //案例：有一个字符串，求出每个字符串的个数：“ddcada”；得出结果：d--3a--2 c--1
        String a = "dddccaab";    //转为字符串数组，循环遍历
        char[] c = a.toCharArray();
        Map<Character,Integer> map = new HashMap<>();//key为字符，value值为次数

        for (int i = 0; i < c.length; i++) {
            Integer count = map.get(c[i]);//根据key获取value，没有返回Null
            if (count == null)  //存储1个
                map.put(c[i],1);
            else
                map.put(c[i],++count);
        }
        System.out.println(map);

    }
}
