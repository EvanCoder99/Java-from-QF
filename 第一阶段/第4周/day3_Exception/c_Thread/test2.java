package week4.day3_Exception.c_Thread;

public class test2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("主线程..."+i);
        }
    }
}
class Task implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程..."+i);
        }
    }
}