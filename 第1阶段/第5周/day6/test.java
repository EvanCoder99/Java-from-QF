package week5.day6;

public class test {
    public static void main(String[] args) {
        //创建账户对象
        Account act = new Account(100);
        //创建2个线程
        AccountThread t1 = new AccountThread(act);
        AccountThread t2 = new AccountThread(act);
//        for (int i = 1; i <= 5 ; i++) {
//            AccountThread t = new AccountThread(act);
//            t.setName("t"+i);
//            t.start();
//        }
        //设置name
        t1.setName("t1");
        t2.setName("t2");
        //启动线程
        t1.start();
        t2.start();
    }
}
