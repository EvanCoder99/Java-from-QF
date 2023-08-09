package week4.day2_Map_Excep.a_Map.c_hashTable;

import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        //Hashtable:和HashMap类似，也是通过hash算法来存储
        //区别在于Hashtable是线程安全，性能低；key或value都不能存null--多线程使用安全的hashMap
        //HashMap是线程不安全，性能高；key或value都能存null-倾向于单线程
        Map<String,Integer> map = new Hashtable<>();
//        map.put(null,666);
//        map.put("aaa",null);//会报错

        //hashTable有一个常用的子类，Properties
        //往往通过面向对象的方式使用，因为里面提供独有方法使用最多
        //key和value一般都是string类型
        Properties p = new Properties();
        p.put("aaa","11");
        System.out.println(p);

        Set<String> set = p.stringPropertyNames();//类似keySet，将Key放进Set集合
        for (String s : set) {
            System.out.println(s + "--" + p.getProperty(s));
        }


    }
}
