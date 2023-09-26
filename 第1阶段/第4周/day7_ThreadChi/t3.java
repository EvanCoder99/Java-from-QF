package week4.day7;


import java.util.concurrent.*;

public class t3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Integer> fu1 = es.submit(new Callable<Integer>() { //匿名内部类，线程1
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 50; i++) {
                    sum+=i;
                }
                return sum;
            }
        });

        Future<Integer> fu2 = es.submit(new Callable<Integer>() { //匿名内部类，线程2
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 51; i <= 100; i++) {
                    sum+=i;
                }
                return sum;
            }
        });
        //子线程处理两种计算，万一子线程还没有算完，get得到的不是0吗？
        //get是阻塞方法--和join类似，插了主线程的队，直到这两个子线程都获得计算结果后，主线程才会继续执行
        int result = fu1.get() + fu2.get();
        System.out.println("结果为："+result);
        es.shutdown();
    }
}
