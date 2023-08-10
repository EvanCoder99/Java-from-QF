package week4.day4_ThreadSafe.d_safe2;

public class test {
    public static void main(String[] args) {
        Store store = new Store();
        //生产者和消费者都操作都一个库存
        new Producter(store).start();

        try {
            new Customer(store).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
