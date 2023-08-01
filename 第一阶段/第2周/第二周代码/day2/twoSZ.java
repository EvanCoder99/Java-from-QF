package week2.day2;

import java.util.Arrays;
import java.util.Scanner;

public class twoSZ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入几行:");
        int n = sc.nextInt();
        int[][] a = new int[n][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[i+1];    //一维数组开辟空间
            for (int j = 0; j < a[i].length; j++) {

                if (j ==0 || j==a[i].length-1)
                    a[i][j] = 1;
                else
                    a[i][j] = a[i-1][j] + a[i-1][j-1];

                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
