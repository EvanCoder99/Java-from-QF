package week4;

//线程代理--模拟线程的执行过程
class ThreadProxy implements Runnable{
    private Runnable target = null;
    @Override
    public void run() {
        if (target != null)
            target.run();//Runnable类中的run方法
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0();
    }

    private void start0() {
        run();
    }
}
class Animal2{}
class Dog extends Animal2 implements Runnable{
    @Override
    public void run() {
        System.out.println("狗叫");
    }
}
public class t1 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        ThreadProxy th = new ThreadProxy(dog);//因为dog实现了Runnable接口，而ThreadProxy类的构造器接收的是接口类型，所以才放进去
        th.start();

    }
}
