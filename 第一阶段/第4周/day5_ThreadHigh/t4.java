package week4;

import java.util.TreeSet;

public class t4 {
    public static void main(String[] args) throws InterruptedException {
        T4 t4 = new T4();
        t4.start();
        System.out.println("主线程休眠10s");
        Thread.sleep(5*1000);//主线程休眠10s，子线程仍然在运行
        t4.setLoop(false);
    }
}
class T4 extends Thread{
    private int count = 0;
    private boolean loop = true;
    @Override
    public void run() {
       while (loop){
           try {
               sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("T4运行中..."+count++);
       }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}