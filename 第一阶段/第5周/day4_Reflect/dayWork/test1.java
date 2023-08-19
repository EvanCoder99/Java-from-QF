package week5.day4_Reflect.dayWork;

class Person{
    String name;
    public Person(String name) {
        this.name = name;
    }
}
public class test1 {
    public static void main(String[] args) throws Exception{
        //1. 自定义Person类,并给定一个带参构造, 当Person类的反射对象调用newInstance时会报错,写个例子演示，并说明为什么?
        Class p = Person.class;
        Object o = p.newInstance();
        //因为newInstance默认调用自定义类的无参构造，若自定义类没有无参构造器，则
    }
}
