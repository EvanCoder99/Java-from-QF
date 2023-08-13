package week4.day7;

public class t1 {
    public static void main(String[] args) {
        Store store = new Store();
        new Productor(store).start();
        new Customer(store).start();
    }
}

class Productor extends Thread {
    private Store store;    //生产者操作库存

    public Productor(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            try {
                store.create();
//                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Customer extends Thread {
    private Store store;    //消费者操作库存

    public Customer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            try {
                store.use();
//                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Store {
    private int count;  //库存--共享数据

    public void create() throws InterruptedException {   //生产的功能
        synchronized (this) {//这里的this是生产者的store调用，是同一个锁对象
            if (count >= 20){
                this.wait();    //仓满大于20则停止生产
            }
            count++;
            System.out.println("已经生产了" + count + "件货");
            this.notify();//唤醒消费者
        }
    }

    public void use() throws InterruptedException {
        synchronized (this) {//这里的this是消费者的store调用，是同一个锁对象
            if (count <= 0) {
                this.wait();    //库存小于0则停止消费
            }
            System.out.println("已经消费了" + count + "件货");
            count--;

            this.notify();//唤醒生产者
        }
    }
}