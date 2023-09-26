package week5.day1_IOStream.a_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class test2 {
    public static void main(String[] args) {
        //通过阻塞队列模拟生产者消费者模型
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        new Thread(new Runnable() {
            @Override
            public void run() {
                //负责生产的线程
                for (int i = 1; i <= 100; i++) {
                    try {
                        queue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("正在生产第"+i+"件货");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //负责消费的线程
                for (int i = 1; i <= 100; i++) {
                    try {
                        System.out.println("正在消费第"+queue.take()+"件货");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }
}
