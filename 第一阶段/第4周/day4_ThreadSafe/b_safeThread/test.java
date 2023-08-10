package week4.day4_ThreadSafe.b_safeThread;

class MyThread extends Thread{
    private static int ticket = 1000;
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        while (true) {
            //同步代码块
            synchronized (this.getClass()) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
                    ticket--;
                } else {
                    System.out.println(Thread.currentThread().getName() + "已经买完了");
                    break;
                }
            }
        }
    }
}

public class test {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new MyThread("第"+i+"窗口").start();
        }
    }
}
