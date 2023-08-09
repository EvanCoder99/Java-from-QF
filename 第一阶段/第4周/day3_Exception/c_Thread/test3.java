package week4.day3_Exception.c_Thread;

class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1);//睡眠-单位毫秒；好处复现线程抢占效果
            } catch (InterruptedException e) {}
            System.out.println(getName()+"..."+i);
        }
    }
}
public class test3 {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("线程1");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();

        MyThread thread2 = new MyThread("线程2");
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.start();
    }
}
