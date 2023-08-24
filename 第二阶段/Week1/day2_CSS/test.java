package day2;

import java.util.Comparator;
import java.util.TreeSet;

class StuComparator implements Comparator<Student1>{
    @Override
    public int compare(Student1 o1, Student1 o2) {
        if (o2.name.equals(o1.name))
            return o1.age-o2.age;
        return o2.name.compareTo(o1.name);//姓名降序
    }
}
class Student1{
    String name;
    int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class test {
    public static void main(String[] args) {
        TreeSet<Student1> set = new TreeSet<>(new StuComparator());
        set.add(new Student1("zs", 18));
        set.add(new Student1("ww",23));
        set.add(new Student1("ww",3));
        set.add(new Student1("zl",53));
        System.out.println(set);
    }
}
