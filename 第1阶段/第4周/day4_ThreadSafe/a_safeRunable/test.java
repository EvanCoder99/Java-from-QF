package week4.day4_ThreadSafe.a_safeRunable;

//案例：买票系统，5个窗口共卖1000张票；观察卖票过程：
//      窗口1正则卖第1800张票；
//      窗口5正在卖第999，
//      窗口3正在卖第150
//......窗口3正在卖第1张票
//分析：5个线程，共享数据：票（安全隐患）
//方式一：实现Runable方式
//问题1--出现部分重票；共享数据有篡改数据，因为还没有--的时候有进程又进来打印输出（隐患）
//解决方案--加锁，锁住共享数据操作，需要考虑锁的范围

//
class Task implements Runnable {
    private int ticket = 1000;//1000张票--共享数据

    @Override
    public void run() {
        while (true) {
           /*同步代码块
           synchronized (this) {
                if (ticket > 0) {
                    //Thread.currentThread（）.getName（）:实现任务获取的线程名
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
                    ticket--;
                } else {
                    System.out.println(Thread.currentThread().getName() + "已经买完了");
                    break;
                }
            }*/

            if (save())
                break;
        }
    }

    //同步方法
    private synchronized boolean save() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
            ticket--;
            return false;//还可以继续循环卖票
        } else {
            System.out.println(Thread.currentThread().getName() + "已经买完了");
            return true;//结束卖票
        }
    }
}
    public class test extends Thread {
        public static void main(String[] args) {
            Task task = new Task();
            for (int i = 1; i <= 5; i++) {
                new Thread(task, "窗口" + i).start();
            }
        }
    }
