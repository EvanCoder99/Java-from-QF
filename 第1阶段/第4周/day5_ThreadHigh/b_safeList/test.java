package week4.day5_ThreadHigh.b_safeList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {
    public static void main(String[] args) {

        List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
        for (int i = 1; i <= 5; i++) {
            final int t = i;//需要重新赋值，因为在匿名内部类中打印，i会变更
            new Thread(new Runnable() {
                @Override
                public void run() {
                    list.add(t);//这里不能打印i

                    System.out.println(list);
                }
            }).start();
        }
    }
}
