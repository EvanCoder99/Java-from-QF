package week4.day3_Exception.c_Thread;

//线程的创建：继承Thread
//案例：主线程、子线程都打印1-200，查看执行结果
public class test {
    public static void main(String[] args) {
        //创建子线程的注意事项： 子线程的创建要放到主线程执行的前面
        myThread thread = new myThread();

        //调父类的start方法
        //start方法将当前线程对象放入线程组，供CPU调度，当CPU调度到你，则你执行（因为run是重写方法，源码会通过this当前对象去调用run），调度到其他线程，则就绪状态

        thread.start();
//        thread.start();//new一次线程对象，不能多次调用，否则报错

        for (int i = 0; i < 10; i++) {
            System.out.println("主线程..."+i);
        }
    }
}
class myThread extends Thread{
    @Override
    public void run() { //子线程执行
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程..."+i);
        }
    }
}