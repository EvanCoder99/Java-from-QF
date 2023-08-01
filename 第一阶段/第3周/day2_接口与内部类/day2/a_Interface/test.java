package week3.day2.a_Interface;


public class test {
    public static void main(String[] args) {
       Fireability fir = new baby();
       fir.fire();
    }

}
interface Fireability{
    int age = 10;
    void fire();
}
class baby implements Fireability{
    @Override
    public void fire() {
        System.out.println("喷火娃在喷火");
    }
    public void print(){
        System.out.println("普通打印");
    }
}
