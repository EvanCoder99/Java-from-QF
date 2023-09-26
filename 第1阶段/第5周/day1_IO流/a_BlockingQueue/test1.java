package week5.day1_IOStream.a_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class test1 {
    public static void main(String[] args) throws InterruptedException {
        //阻塞队列：有两个实现类：有界队列、无界队列
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.put("zs");
        queue.put("ls");
        queue.put("ww");
//        queue.put("zl");//超出个数则阻塞，不会输出
        System.out.println(queue);

        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());//获取，每次取出都会移位；超过了也会阻塞
    }
}
