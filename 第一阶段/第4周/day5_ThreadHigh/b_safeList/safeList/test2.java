package week4.day5_ThreadHigh.b_safeList.safeList;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class test2 {
    public static void main(String[] args) {
        //并发集合
        List<Integer> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 5; i++) {
            final int t = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    list.add(t);//写

                    System.out.println(list);//读
                }
            }).start();
        }
    }
}
