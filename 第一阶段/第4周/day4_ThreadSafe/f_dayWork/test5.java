package week4.day4_ThreadSafe.f_dayWork;

public class test5 {
    public static void main(String[] args) {
        //5.模拟接力跑,1000米,10个人,每人跑100米,1个人跑完下个人接着跑(synchronized)
        //打印信息提示：线程n跑完100米，还剩900米..
        MZ mz = new MZ();
        for (int i = 1; i <= 10; i++) {
            new Thread(mz,"线程"+i).start();
        }

    }
}

class MZ implements Runnable {
    static int meters = 1000;

    @Override
    public void run() {
        synchronized ("LUCK"){
            System.out.println(Thread.currentThread().getName() + "跑完100米，还剩" + (meters -= 100) + "米");
        }
    }


}