package week5.day6;

public class Account {
     private int balance;

    public Account(int balance){
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withDraw(int money){
        synchronized(this){
            //取款后的余额
            int after = balance - money;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //更新余额
            setBalance(after);
        }
    }
}
