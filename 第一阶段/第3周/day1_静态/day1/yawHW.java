package week3.day1;

import java.util.Scanner;

public class yawHW {
    public static final int BIRD = 1;
    public static final int FISH = 3;

    public static void main(String[] args) {
        /*1.为什么写main方法的时候需要这么设计? 请分析说明
        public static void main(String[] args){}
        public
        答：public修饰符可以在不同包不同类中访问，权限最高，作为程序的入口这样设计有利于执行代码，以便被其它类访问

        static？
        答：主要是让编译器知道main方法是一个静态方法，这样在类加载时，就已经加载了静态成员。如果不设置为static，由于加载时机问题，程序没有建立任何实例对象，无法调用实例成员，非静态的mian方法找不到程序的入口。而static修饰后，mian方法就无需实例化就可以调用，减少不必要的内存占用

        void？
        答：因为是程序的入口，一般不需要返回值

        2.为什么main方法里面直接调用方法，则该方法就必须是static的，而通过对象调用则不要求该方法为静态的？
        答：因为main方法是静态方法，随着类的加载就已经创建了，在main方法里调用非静态方法，因为加载时机问题，静态方法优先加载，此时非静态方法还没创建，或者说没有实例化对象，因此mian方法不找不到，所以无法调用。通过对象调用无需静态是因为已经实例化了对象。
        */


        //3.创建一个类，有自己的静态代码块, 动态代码块、构造方法。在测试类中创建该类的多个对象，判断其执行结果
        new A();
        System.out.println("-----------");
        new A();
        System.out.println("-----------");
        new A();


        /*
        * 4.判断下面的说法是否正确，并阐述理由
          在静态方法中可以直接使用非静态变量	    错，因为此时非静态变量还未创建或者说实例化
          在非静态方法中可以调用静态方法		    对，因为静态方法先于非静态变量创建
          静态方法中不能使用this关键字		    对，this表示当前对象，静态方法创建时，对象还未实例
          用static声明的方法为静态方法，调用此方法时可直接用类名调用		对，因为静态方法随类一起创建。
        *
        * */
        //5.将之前抽象类的返回值实现多态的标记，使用状态值来替换，并完成该案例
        Scanner sc = new Scanner(System.in);
        Boy boy = new Boy();
        Toy toy = boy.buy(BIRD);
        toy.start();
        Toy toy1 = boy.buy(FISH);
        toy1.start();

    }
}

abstract class Toy {
    public abstract void start();
}

class Bird extends Toy {
    @Override
    public void start() {
        System.out.println("玩具鸟正在发射..");
    }

}

class Fish extends Toy {
    @Override
    public void start() {
        System.out.println("玩具鱼正在发射..");
    }
}

class Boy {
    public Toy buy(int type) {
        if (type == 1) {
            return new Bird();
        } else if (type == 3) {
            return new Fish();
        } else {
            return null;
        }
    }
}

class A {
    public A() {
        System.out.println("A类的构造器");
    }

    static {
        System.out.println("A类的静态代码块");
    }

    {
        System.out.println("A类的动态代码块");
    }
}