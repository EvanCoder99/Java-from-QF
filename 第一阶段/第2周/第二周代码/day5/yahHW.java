package week2.day5;

import java.util.Scanner;

public class yahHW {
    public static void main(String[] args) {
        //1.把狗当动物看待，可以重写动物类叫的方法
        Animal animal = new Dog();
        animal.cry();

        //2.俄乌战争冲突，需要添加武器到战场上，并使用不同的武器攻击
        //战场类
        //	添加武器方法
        //武器类 -父
        //	武器的攻击
        //坦克-子
        //飞机-子
        //战船-子
        System.out.println("==============2==============");
        Battlefield battlefield = new Battlefield();
        System.out.println("俄乌冲突升级，请添加到达战场的武器：1、坦克  2、飞机  3、战舰");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n){
            case 1:
                battlefield.war(new Tank());break;
            case 2:
                battlefield.war(new Plane());break;
            case 3:
                battlefield.war(new Boat());break;
            default:
                System.out.println("输入有误");
        }
    }
}

class Battlefield{
    public void war(Weapons weapons){
        weapons.attack();
    }
}
abstract class Weapons{
    abstract public void attack();
}
class Tank extends Weapons{
    @Override
    public void attack() {
        System.out.println("豹式坦克正在射炮~");
    }
}
class Plane extends Weapons{
    @Override
    public void attack() {
        System.out.println("B-20飞机在天空准备轰炸~");
    }
}
class Boat extends Weapons{
    @Override
    public void attack() {
        System.out.println("战舰准备攻击~~~");
    }
}

abstract class Animal{
    abstract public void cry();
}
class Dog extends Animal{
    @Override
    public void cry() {
        System.out.println("你在狗叫什么~~~~");
    }
}