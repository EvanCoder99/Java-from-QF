package week3.day1.b_DaiMaKuai;
class A{
    String name = "成员属性";
    int a = 9;
    public A() {  //构造方法
        System.out.println("构造方法");
    }
    //动态代码块
    {
        a = 10;
        System.out.println(name + " " + a);
        System.out.println("动态代码块");
    }
}
public class test {
    //动态代码块应用：

        public static void main(String[] args) {
            new A();

    }
}
