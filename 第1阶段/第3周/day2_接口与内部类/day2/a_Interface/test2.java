package week3.day2.a_Interface;

public class test2 {
    public static void main(String[] args) {
        //1.面向对象
        Dog dog = new Dog();
    }

}
abstract class Animal{
    public abstract void eat();
}
interface runAbility{
    public abstract void run();
}
class Dog extends Animal implements runAbility{
    @Override
    public void run() {
        System.out.println("实现接口的run方法");
    }

    @Override
    public void eat() {
        System.out.println("重写父类的eat方法");
    }
}