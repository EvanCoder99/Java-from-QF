package day2;

import java.util.TreeSet;

class Student implements Comparable<Student>{
    int age;

    public Student(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.age-o.age;  //升序
//        return o.age-this.age;  //升序
    }

    @Override
    public String toString() {
        return "Student[" +
                "age=" + age +
                ']';
    }
}
public class treeset {
    public static void main(String[] args) {
        TreeSet<Student> set = new TreeSet<>();
        set.add(new Student(6                                                                                                    ));
        set.add(new Student(8));
        set.add(new Student(5));
        set.add(new Student(2));

        for (Student student : set) {
            System.out.println(student);
        }
    }
}
