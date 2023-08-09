package week4.day3_Exception.c_Thread.ChaDui;

class MyTh extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程..."+i);
        }
    }
}
public class test {
    public static void main(String[] args) throws InterruptedException {
        MyTh myTh = new MyTh();
        myTh.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程..."+i);
            if (i==5){
                myTh.join();
            }

        }
    }
}
