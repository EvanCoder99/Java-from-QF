package week2.day4;

public class test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "旺财"; //调父类的属性
        dog.color = "黄色"; //调自身独有属性
        dog.run();      //调自身独有方法
        dog.sleep();    //调父类方法
        System.out.println("--------------");

        Bird bird = new Bird();
        bird.name = "八哥";
        bird.fly();
        bird.eat();
        System.out.println("--------------");

        Fish fish = new Fish();
        fish.name = "小金";
        fish.swim();
        fish.sleep();

    }
}
class Animal{
    String name;
    int    age;
    public void eat() {
        System.out.println(name+"正在吃...");
    }
    public void sleep() {
        System.out.println(name+"正在睡...");
    }
}
class Dog extends Animal{  //Dog继承Animal
    String color;
    public void run() {
        System.out.println(name+"正在跑");
    }
}
class Bird extends Animal{ //Bird继承Animal
    String color;
    public void fly() {
        System.out.println(name+"正在飞");
    }
}
class Fish extends Animal{ //Fish继承Animal
    public void swim() {
        System.out.println(name+"正在游");
    }
}