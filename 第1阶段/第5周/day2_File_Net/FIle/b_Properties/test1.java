package week5.day2_File_Net.FIle.b_Properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Set;

public class test1 {
    public static void main(String[] args) throws Exception {
        Properties p = new Properties();
        p.put("aa","111");
        p.put("cc","666");
        p.put("bb","333");

        //将集合的数据，存储到文件中
        p.store(new FileOutputStream("a.txt"),"666");

        //将文件中的数据进行加载
        Properties p2 = new Properties();
        p2.load(new FileInputStream("a.txt"));
        System.out.println(p2);
        System.out.println(p2.getProperty("aa"));

        Set<String> set = p2.stringPropertyNames();//把所有key放入Set集合
        for (String key : set) {
            System.out.println(key + "--" + p2.getProperty(key));
        }
    }
}
