package week4.day5_ThreadHigh.a_ChongRuLock;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//模拟List集合，使用重入锁处理
class MyList {
    Lock lock = new ReentrantLock();//重入锁
    String[] a = {null, null};
    int index;

    public void add(String value) {
        try {
            lock.lock();//获取锁对象
            a[index++] = value;
        } finally { //无论如何都会释放
            lock.unlock();//释放锁对象
        }

    }
}

public class test {
    public static void main(String[] args) throws InterruptedException {
        MyList myList = new MyList();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myList.add("hello");
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                myList.add("word");
            }
        });
        t2.start();

        t1.join();
        t2.join();

        System.out.println(Arrays.toString(myList.a));
    }
}
