package week4.day5_ThreadHigh.c_weekTest;

import java.util.*;

public class test1 {
    public static void main(String[] args) {
        //1. JAVA编程题:字符串"yekmaakkccekymbvb",求出字符串中有多少种字符,以及每个字符的个数，请使用集合进行操作
        HashMap<Character,Integer> map = new HashMap<>();
        char[] c = "yekmaakkccekymbvb".toCharArray();
//        for (Character d: c) {
//            if (map.get(d) == null){
//                map.put(d,1);
//            }else{
//                map.put(d,map.get(d)+1);
//            }
//        }

        for (int i = 0; i < c.length; i++) {
            if (map.get(c[i]) == null){
                map.put(c[i],1);
            }else{
                map.put(c[i],map.get(c[i])+1);
            }
        }
        System.out.println("共有"+map.size()+"种字符，对应个数分别如下：");
        System.out.println(map);

    }
}
