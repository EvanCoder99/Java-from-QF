package week4.day2_Map_Excep.a_Map.a_hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//hashMap的key存储自定义对象
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
public class test2 {
    public static void main(String[] args) {
        Map<Student,Integer> map = new HashMap<>();
        map.put(new Student("zs",13),1);
        map.put(new Student("ls",10),2);
        map.put(new Student("ww",20),3);
        map.put(new Student("zs",13),1);
        System.out.println(map);
    }
}
