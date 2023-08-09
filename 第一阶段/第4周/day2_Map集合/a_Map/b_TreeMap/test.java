package week4.day2_Map_Excep.a_Map.b_TreeMap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//TreeMap
public class test {
    public static void main(String[] args) {
        //TreeMap
        Map<String,Integer> map = new TreeMap<>();
        map.put("a",1);
        map.put("b",3);
        map.put("c",2);
        map.put("a",1);
        System.out.println(map);
        System.out.println(map.get("c"));

        //循环遍历：keySet，entrySet
        //1、keySet
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s + "==" + map.get(s));
        }

        System.out.println("---------------");

        //2、entrySet
        Set<Map.Entry<String,Integer>> ent = map.entrySet();
        for (Map.Entry<String, Integer> sie : ent) {
            System.out.println(sie.getKey() + "--" + sie.getValue());
        }
    }
}
