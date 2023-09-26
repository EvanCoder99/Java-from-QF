package week4.day4_ThreadSafe.d_safe2;

public class Producter extends Thread{
    private Store store;
    public Producter(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            try {
                store.push();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
