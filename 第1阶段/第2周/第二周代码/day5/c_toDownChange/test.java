package week2.day5.c_toDownChange;

public class test {
    public static void main(String[] args) {
        //new B();  //构造方法没有继承性，不能调用父类A的带参构造
        for (int i = 0; i < 3; i++) {

        }
    }
}
class A{
    public A() {
        System.out.println("父类A的无参构造");
    }
    public A(int a) {
        System.out.println("父类A的带参构造");
    }
}
class B extends A{
}