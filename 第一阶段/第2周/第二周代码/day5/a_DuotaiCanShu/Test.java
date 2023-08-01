package week2.day5.a_DuotaiCanShu;

//案例：主人限养宠物，猫，狗都是宠物，都有各自吃的行为
//分析：宠物类，猫类，狗类，主人类
public class Test {
    public static void main(String[] args) {
        Master master = new Master();
        master.feed(new Dog());
        master.feed(new Cat());

    }
}
class Animal{
    public void eat(){
        System.out.println("动物正在吃~~~");
    }
}
class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("旺财正在吃~~");
    }
}
class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("金渐层正在吃~~");
    }
}
class Master{
    public void feed(Animal animal){
        animal.eat();
    }
}