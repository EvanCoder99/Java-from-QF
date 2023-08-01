package week1.day03;

import java.util.Scanner;

public class dddd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1. 将3行5列的嵌套循环,用方法封装,其中行和列从调用处传入
        System.out.println("==============第1题==============");
        System.out.print("请输入行:");
        int row = sc.nextInt();
        System.out.print("请输入列");
        int col = sc.nextInt();
        xunhuan(row,col);

    }
    public static void xunhuan(int row,int col){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("T");
            }
            System.out.println();
        }
    }

}
