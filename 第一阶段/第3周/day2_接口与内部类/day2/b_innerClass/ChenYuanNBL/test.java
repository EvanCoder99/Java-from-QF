package week3.day2.b_innerClass.ChenYuanNBL;

class Outer{
    private String name = "凤姐";
    public void print(){
        new Inner().test();//外部类调用内部类方法
    }

    class Inner{
        String name = "芙蓉";
        public void test(){
            System.out.println(name);
            System.out.println(Outer.this.name);//内部类调用外部类重名属性
            System.out.println(new Outer().name);
        }
    }
}
public class test {
    public static void main(String[] args) {
        //1、使用外部类调用外部方法
        Outer out = new Outer();
        out.print();

        //2、直接调用内部类方法，通过外部类对象，产生内部类对象
        Outer.Inner inner = new Outer().new Inner();
    }
}
