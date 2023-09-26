package week5.day5.dayWorl;

import com.sun.org.apache.bcel.internal.generic.POP2;

import javax.rmi.CORBA.Stub;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class test2 {
    public static void main(String[] args) {
        //2.使用Stream进行排序， Stream中操作Person对象，里面有name，age属性，按照年龄进行降序排列
        List<Person> list = new ArrayList<>();
        list.add(new Person("张三",12));
        list.add(new Person("李四",25));
        list.add(new Person("王五",1));

        System.out.println(list);
        list.stream().sorted((p1, p2)->p2.age-p1.age).forEach(System.out::println);
    }
}
