package week3.day3.b_ObjectClass.UnNameInnerClass;

public class test {
    public static void main(String[] args) {
        //1.接口直接引用的多态
        Fireable able = new WaWa();
        able.fire();
        //2.匿名内部类的方式
        Fireable able2 = new Fireable() {
            @Override
            public void fire() {
                System.out.println("匿名内部类的喷火..");
            }
        };
        able2.fire();
    }
}
interface Fireable{
    void fire();
}
class WaWa implements Fireable{
    @Override
    public void fire() {
        System.out.println("喷火娃正在喷火...");
    }
}