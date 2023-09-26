package week4.day4_ThreadSafe.f_dayWork;

public class test2_3_4 {
    public static void main(String[] args) {
        //2.描述synchronized关键字的作用
        /*
        *synchronized作为关键字，可以修饰方法或者修饰代码块。
        * 修饰方法就是同步方法，修饰代码块就是同步代码块
        * 多个线程同时访问一个数据区，有可能会把里面的数据出现安全隐患，使得共享数据发生数据安全性问题，synchronized可以锁住当前运行这段代码的对象，这样其他线程就不能同时访问这个对象中被synchronized锁住的代码
        * */

        //3.简单描述什么是死锁
        /*
        * 当一个线程进入锁中没有退出，而其他线程又进不来，即构成死锁
        * */

        //4.卖100张票,创建2个线程一起卖  使用继承Thread的同步代码块和同步方法完成
        //问题：同步方法必须加static才能锁得住，为什么？
        //因为每次new一个线程对象，其属性都是不同对象的，要让票数数据共享，必须设置成静态属性

        for (int i = 0; i < 2; i++) {
            new MyThread2("窗口"+i).start();
        }


    }
}
class MyThread2 extends Thread{
    private static int ticket=100;
    public MyThread2(String name){
        super(name);
    }

    @Override
    public void run() {
        while (true){
            //同步代码块方式
//            synchronized ("lock") {
//                if (ticket > 0)
//                    System.out.println(getName()+"正在卖第"+(ticket--)+"张票（同步代码块）");
//                else{
//                    System.out.println(getName()+"已经卖完了所有的票（同步代码块）");break;
//                }
//            }

            //同步方法
            if (sell())
                break;
        }
    }
    private synchronized boolean sell(){
        if (ticket > 0){
            System.out.println(getName()+"正在卖第"+(ticket--)+"张票（同步方法）");
            return false;
        }
        else{
            System.out.println(getName()+"已经卖完了所有的票（同步方法）");
            return true;
        }
    }

}