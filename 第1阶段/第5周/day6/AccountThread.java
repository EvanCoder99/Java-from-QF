package week5.day6;

public class AccountThread extends Thread {
    private Account act;

    public AccountThread(Account act) {
        this.act = act;
    }

    @Override
    public void run() {
        int money = 20;
        act.withDraw(money);
        System.out.println("账户" + getName() + "取款成功，余额：" + act.getBalance());
    }
}
