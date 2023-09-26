package week3.day2.b_innerClass.staticNBL;


class Outer{
   private String name = "凤姐";
   private static int age = 2;
   static class Inner{
       public void print(){
           //System.out.println(name);  //静态内部类中不能使用成员变量
           System.out.println(age); //可使用外部类的静态成员变量
           System.out.println("内部类方法的调用");
       }
   }
}
public class test {
    public static void main(String[] args) {
        //调用静态内部类
        //方式一：通过类名调用资源
        Outer.Inner inner = new Outer.Inner();
        inner.print();

        //方式二：直接导包

    }
}
