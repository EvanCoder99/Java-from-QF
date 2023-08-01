package week3.day1.a_Static;

class A {
    static public void say() {
        System.out.println("父类的静态方法");
    }
}
class B extends A{

    static public void say() {
        System.out.println("子类的静态方法");
    }
}
public class test {
    public static void main(String[] args) {
        A a = new B();
        a.say();

        B b = (B)a;
        b.say();

        B b1 = new B();
        b1.say();

    }
}
