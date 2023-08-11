package week4.day5_ThreadHigh.c_weekTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            if (sell())
                break;
        }
    }

    private synchronized boolean sell() {
        if (ticket > 0){
            System.out.println("窗口"+Thread.currentThread().getName()+"正在卖第"+(ticket--)+"张票");
            return false;
        }else{
            System.out.println("窗口"+Thread.currentThread().getName()+"已经卖完了");
            return true;
        }


    }
}
public class test4 {
    public static void main(String[] args) {
        //4. 使用线程池完成5个窗口卖100张票；并处理线程安全；线程名默认即可
        ExecutorService es = Executors.newFixedThreadPool(5);
        Task task = new Task();
        for (int i = 0; i < 5; i++) {
            es.submit(task);
        }
        es.shutdown();

    }
}
