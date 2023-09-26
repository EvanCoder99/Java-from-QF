package week3.day1.b_DaiMaKuai;

public class test2 {
    public static void main(String[] args) {
        new D();
    }
}

//静态代码块：static{}
//执行顺序：静态属性>静态代码块
//作用：用于给静态属性赋值
class D {
    static String name = "静态属性";

    static {
        System.out.println(name);
        System.out.println("静态代码块");
    }

}