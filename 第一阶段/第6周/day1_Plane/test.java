package day1_Plane;

import java.util.Random;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Person{
    int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
public class test {
    public static void main(String[] args) {
//        Person p1 = new Person(33);
//        Person p2 = new Person(22);
//        Person p3 = new Person (11);
//
//        TreeSet<Person> persons = new TreeSet<>();
//        persons.add(p1);
//        persons.add(p2);
//        persons.add(p3);
//        for (Person p : persons) {
//            System.out.println(p);
//        }

        Predicate<String> pre = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.endsWith("llo");
            }
        };
        System.out.println(pre.test("hello"));
    }
}
