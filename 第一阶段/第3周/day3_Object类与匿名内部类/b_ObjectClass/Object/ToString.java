package week3.day3.b_ObjectClass.Object;

public class ToString {
    public static void main(String[] args) {
        Dog d = new Dog("wangcai", 3);
        System.out.println(d.toString());
        System.out.println(d);

    }
}
class Dog{
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return name+":"+age;
//    }
}