package week2.day5.d_Abstract;

public class test {
    public static void main(String[] args) {
        //为什么不用Dog dog = new Dog()去调cry（）？
        //为了限制子类权限
        //1、规范和局限在抽象类里面设置好的属性和方法
        //2、有些时候父类的方法没有用到，抽象类就解决了这个问题
        Animal animal = new Dog();
        animal.cry();
    }
}
abstract class Animal{
    public abstract void cry();
}
//解决办法：1、重写父类抽象方法 2、把自己变抽象
class Dog extends Animal{
    @Override
    public void cry() {
        System.out.println("哮天犬往往阿旺");
    }
}