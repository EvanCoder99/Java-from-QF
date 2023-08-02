package week3.day3.b_ObjectClass.Object;
class Person{
}
public class GetClass {
    public static void main(String[] args) {
        Class c1 = new Person().getClass();
        Class c2 = new Person().getClass();
        //==：在引用类型中，用于比较地址；同一块地址则为true；不同则为false
        System.out.println(new Person()==new Person()); //false
        System.out.println(c1==c2); //true
        Class c3 = new GetClass().getClass();
        System.out.println(c1==c3); //false
    }
}
