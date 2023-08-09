package week4.day1_Set.TreeSet;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

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
        Set<Student> set = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //先按姓名降序，姓名相同，再按年龄升序
                if (o1.name.equals(o2.name))
                    return o1.age-o2.age;
                return o2.name.compareTo(o1.name);
            }
        });
        set.add(new Student("zs",22));
        set.add(new Student("ls",2));
        set.add(new Student("ww",1));
        set.add(new Student("zs",3));
        set.add(new Student("zs",22));
        System.out.println(set);
    }
}
