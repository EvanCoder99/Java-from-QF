package week1.day03;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
//       int[] a = new int[]{1,2,3};
//
//       int sum =0,avg;
//        for (int i = 0; i < a.length; i++) {
//            sum+=a[i];
//        }
//        System.out.println("平均值："+sum/a.length);

        int[] b = new int[]{1,2,3,4,5,6,7,8,9};
        Scanner sc= new Scanner(System.in);
        System.out.print("请输入一个数字：");
        int n = sc.nextInt();
        for (int i = 0; i < b.length; i++) {
            if (n == b[i]){
                System.out.println("下标为："+i);
                return;
            }
            if (n != b[i]){
                System.out.println("-1");continue;
            }
        }


    }
}
