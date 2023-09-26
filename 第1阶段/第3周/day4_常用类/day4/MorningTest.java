package week3.day4;

public class MorningTest {
    public static void main(String[] args) {
        Person a = new Person("王二", 3);
        Person a1 = new Person("王二", 4);
        System.out.println(a.equals(a1));
    }
}
class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person){
            return name.equals(((Person) o).name) && age == ((Person) o).age;
        }else {
            return false;
        }
    }
}