package week3.day4.c_Random;

import java.util.Random;

public class test1 {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(5 ));  //0-4的随机值

        int val = getRandom(75,100);
        System.out.println(val);

    }

    private static int getRandom(int start, int end) {
        Random r = new Random();
        ////[start，end)
        return r.nextInt(end-start+1)+start;
    }
}
