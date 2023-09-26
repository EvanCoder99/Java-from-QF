package week4.day4_ThreadSafe.c_deadLock;

class MyThread extends  Thread{
    private boolean a;
    public MyThread(boolean a){
        this.a = a;
    }
    @Override
    public void run() {
        if (a){
            synchronized ("A"){
                System.out.println("进入线程1的A锁");
                synchronized ("B"){
                    System.out.println("进入线程1的B锁");
                }
            }
        }else {
            synchronized ("B"){
                System.out.println("进入线程2的B锁");
                synchronized ("A"){
                    System.out.println("进入线程2的A锁");
                }
            }
        }
    }
}
public class test {
    public static void main(String[] args) {
        new MyThread(true).start();

        new MyThread(true).start();
    }
}
