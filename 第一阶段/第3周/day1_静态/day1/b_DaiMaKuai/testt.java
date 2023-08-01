package week3.day1.b_DaiMaKuai;

public class testt {
    public static void main(String[] args) {
//        new Super(); //静态属性>静态代码块>成员属性>动态代码块>构造方法
//        System.out.println("---------------");
//        new Super();  //成员属性>动态代码块>构造方法   静态的只加载一次
//        System.out.println("---------------");
        new Son();
    }
}
class Super{
    String name = "父类成员属性";
    public Super() {  //构造方法
        System.out.println("父类构造方法");
    }
    //动态代码块
    {
        System.out.println(name);
        System.out.println("父类动态代码块");
    }

    static String name2="父类静态属性";
    static {
        System.out.println(name2);
        System.out.println("父类静态代码块");
    }
}
class Son extends Super{
    String name = "子类成员属性";
    public Son() {  //构造方法
        System.out.println("子类构造方法");
    }
    //动态代码块
    {
        System.out.println(name);
        System.out.println("子类动态代码块");
    }

    static String name2="子类静态属性";
    static {
        System.out.println(name2);
        System.out.println("子类静态代码块");
    }
}