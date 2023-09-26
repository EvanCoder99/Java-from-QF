package week4;

class Sell1 extends Thread{
    private static int ticket = 100;//让多个线程共享票数
    public Sell1(String name) {
        super(name);
    }
    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                try {
                    Thread.sleep(100);//卖票需要时间，所以休眠
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"卖了一张票，还剩"+(--ticket));
            }else
                break;
        }
    }
}

class Sell2 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                try {
                    Thread.sleep(100);//卖票需要时间，所以休眠
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"卖了一张票，还剩"+(--ticket));
            }else
                break;
        }
    }
}
public class SELL {
    public static void main(String[] args) {
        //通过Thread方式
        Sell1 se1 = new Sell1("窗口1：");
        se1.start();
        Sell1 se2 = new Sell1("窗口2：");
        se2.start();
        Sell1 se3 = new Sell1("窗口3：");
        se3.start();

        //通过Runnable方式
//        Sell2 s2 = new Sell2();
//        Thread t = new Thread(s2,"窗口1"); t.start();
//        new Thread(s2,"窗口2：").start();
//        new Thread(s2,"窗口3：").start();

    }
}
