package week4.day4_ThreadSafe.e_Pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Task implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }
}
//线程池
public class test {
    public static void main(String[] args) {
        //在线程池中创建单个线程对象，通过单个线程对象去处理多个任务
        //ExecutorService es = Executors.newSingleThreadExecutor(); //不常用

        //带缓冲区的线程池：有多少任务，就会产生多少个线程对象的处理
//        ExecutorService es = Executors.newCachedThreadPool();

        //带复用机制的线程池：指定线程池个数，进行复用
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new Task());
        es.submit(new Task());
        es.submit(new Task());//有三个任务，谁先执行完，再执行第三个--复用

        es.shutdown();//线程池的终止
    }
}
