package week4.day4_ThreadSafe.d_safe2;

public class Customer extends Thread{
    private Store store;
    public Customer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            try {
                store.pop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
