package week4.day7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{
//    public Task(String name){
//        super(name);
//    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName()+"--->"+i);
//            System.out.println(getName()+"--->"+i);
        }
    }
}
public class t2 {
    public static void main(String[] args) {
        //1、在线程池中创建单个线程对象，通过单个线程对象去处理多个任务
//        ExecutorService es = Executors.newSingleThreadExecutor();//不常用

        //2、带缓冲区的线程池：有多少个任务，就会创建多少个线程对象去处理，但这种和手动创建线程没多大区别，不常用
//        ExecutorService es = Executors.newCachedThreadPool();//需要手动终止线程池

        //3、带复用机制的线程池：指定线程池的个数，进行复用
        ExecutorService es = Executors.newFixedThreadPool(2);//在池中创建2个线程对象去处理任务，如果有三个任务，则某线程先执行完后，回收到线程池，再去执行第三个任务，故达到复用

        //因为没有共享数据，所以没有线程安全隐患
        //可以是单个线程，执行多个任务
        es.submit(new TASK2());
        es.submit(new TASK2());

        //也可以是单个线程，执行多次同一个任务
//        Task task = new Task();
//        es.submit(task);
//        es.submit(task);

        es.shutdown();
    }
}
