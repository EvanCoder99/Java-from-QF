package week4.day5_ThreadHigh;
class Outter3{
    String name = "张三";
    public void show() {
        int age = 30;
        class Inner3{ //局部内部类
            public void test() {
                System.out.println("调用局部内部类--"+name);
                //age = 40; //外部类Outter3的show方法中定义的变量，会自动变为常量  +final
                //原因是age的作用域要与局部内部类保持一致
                System.out.println(age);
            }
        }

        new Inner3().test();  //在当前方法中，才能调用局部内部类
    }
}
public class d {
    public static void main(String[] args) {
        new Outter3().show();
    }
}