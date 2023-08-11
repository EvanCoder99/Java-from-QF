package week4.day5_ThreadHigh.c_weekTest;

import java.util.Arrays;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        //3. 从屏幕输入10个数，在输入错误的情况下，给出相应的提示，并继续输入。在输入完成的情况下，找到最大最小数。
        int[] d = new int[10];
        int i = 0;
            try {
                Scanner sc = new Scanner(System.in);
                while (i < 10) {
                    System.out.println("输入第" + (i+1) + "个数字：");
                    int num = sc.nextInt();
                    d[i] = num;
                    i++;
                }
            } catch (Exception e) {
                System.out.println("输入有误！重新输入：");
                e.printStackTrace();
                Scanner sc = new Scanner(System.in);
            }
        Arrays.sort(d);
        System.out.println("最大值：" + d[d.length-1]);
        System.out.println("最小值：" + d[0]);


    }

}
