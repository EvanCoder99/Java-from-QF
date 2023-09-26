package week4.day3_Exception.c_Thread.yield;

//线程礼让
//案例：两个子线程都打印1~200；其中一个线程每次执行都进行礼让，查看执行的结果
public class test {
    public static void main(String[] args) {
        new A().start();
        new B().start();
    }
}
class A extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Thread.yield();//A线程礼让，理论上执行更慢，但不绝对
            System.out.println("A线程..."+i);
        }
    }
}
class B extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("B线程..."+i);
        }
    }
}