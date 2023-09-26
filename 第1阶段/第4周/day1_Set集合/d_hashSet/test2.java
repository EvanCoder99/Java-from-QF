package week4.day1_Set.d_hashSet;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
        Set<Student> set = new HashSet<>();
        set.add(new Student("zs",1));
        set.add(new Student("ls",2));
        set.add(new Student("zs",1));
        System.out.println(set);
    }
}
