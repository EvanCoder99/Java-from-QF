package week4.day2_Map_Excep.a_Map.a_hashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        //hashMap的基本应用，无序、唯一性只和key有关，但确定唯一性后，后面的value会覆盖前面的
        Map<String,Integer> map = new HashMap<>();
        map.put("a",6);
        map.put("c",9);
        map.put("b",6);
        map.put("bb",1);
        System.out.println("打印map集合："+map);

        //调用方法
        System.out.println(map.get("c"));//根据key获取value值
        Collection<Integer> c = map.values();//将所有的value放入Collection集合
        System.out.println("将c的value值放入Collection集合中："+c);

        //循环：1、基本for不行，无下标
        for (int i = 0; i < map.size(); i++) {}

        //增强for 不行，没有统一的类型，因为是键值对
//        for(String key : map){}

        //只能间接循环：keySet、entrySet
        //1、keySet：将所有key放入Set集合（无序唯一），然后循环根据key遍历出value
        Set<String> set = map.keySet();
        System.out.println("间接循环：");
        for (String s : set) {
            System.out.println(s+"--"+map.get(s));
        }

        //2、entrySet：将键值对作为实体存到Set，再循环Set取出实体拿出里面的键值对
        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + "==" + entry.getValue());
        }



    }
}
