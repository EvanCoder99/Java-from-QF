package week4.day4_ThreadSafe.d_safe2;

//仓满和仓空有库存决定
public class Store {

    private int count;//库存数量的标记--共享数据
    public void push() throws InterruptedException {//负责生产的功能
        synchronized (this){
            if (count >= 20)    //仓满则停止生产
                this.wait();
            System.out.println("已经生产了"+(count++)+"件货");
        }
    }

    public void pop() throws InterruptedException {//负责消费的功能
        synchronized (this){
            if (count <= 0) //仓空停止消费
                this.wait();    //等待
            System.out.println("已经消费了"+(count--)+"件货");
        }
    }
}
