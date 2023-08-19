package week5.day5.dayWorl;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Person3{
    String name;
    int age;

    public Person3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person3 person = (Person3) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person3 {" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class test3 {
    public static void main(String[] args) {
        //3.Stream中操作Person对象的，里面有name，age属性，请使用map映射，遍历出Peson的name属性
        List<Person> list = new ArrayList<>();
        list.add(new Person("张三",12));
        list.add(new Person("李四",25));
        list.add(new Person("王五",1));

        //map：将元素映射成元素的属性，放到Stream中
        list.stream().map(person -> person.name).forEach(System.out::println);
    }
}
