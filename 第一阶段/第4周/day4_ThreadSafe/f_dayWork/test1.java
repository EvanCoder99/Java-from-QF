package week4.day4_ThreadSafe.f_dayWork;

public class test1 {
    public static void main(String[] args) {
        //1.利用线程输出从a到z的26个字母，每隔一秒钟输出一个字母
        new MyThread1().run();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        char a = 'a';
        for (int i = 0; i < 26; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(a++);
        }
    }
}