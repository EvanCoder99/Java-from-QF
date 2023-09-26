package week4.day2_Map_Excep.a_Map.b_TreeMap;

import java.util.Map;
import java.util.TreeMap;

//TreeMap的key存储自定义对象 --验证原理：有两个属性
class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class test2 {
    public static void main(String[] args) {
        Map<Student,Integer> map = new TreeMap<>();
        map.put(new Student("zs",666),1);
        map.put(new Student("zs",666),1);
        map.put(new Student("zs",666),1);
        map.put(new Student("zs",666),1);

    }
}
