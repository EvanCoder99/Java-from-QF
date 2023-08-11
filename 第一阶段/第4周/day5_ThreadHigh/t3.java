package week4;

public class t3 {
    public static void main(String[] args) {
        //通过Thread方式
//        Sell1 s1 = new Sell1();
//        s1.start();
//        Sell1 s2 = new Sell1();
//        s2.start();
//        Sell1 s3 = new Sell1();
//        s3.start();

        //通过Runnable方式
        Sell2 s2 = new Sell2();
        Thread t = new Thread(s2);
        t.start();
        new Thread(s2).start();
        new Thread(s2).start();

    }
}
class Sell1 extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                try {
                    Thread.sleep(100);//卖票需要时间，所以休眠
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("窗口"+Thread.currentThread().getName()+"卖了一张票，还剩"+(--ticket));
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
                System.out.println("窗口"+Thread.currentThread().getName()+"卖了一张票，还剩"+(--ticket));
            }else
                break;
        }
    }
}