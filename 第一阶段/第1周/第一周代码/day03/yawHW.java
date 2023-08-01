package week1.day03;

import java.util.Scanner;

public class yawHW {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //1. 将3行5列的嵌套循环,用方法封装,其中行和列从调用处传入
        System.out.println("==============第1题==============");
        System.out.print("请输入行:");
        int row = sc.nextInt();
        System.out.print("请输入列");
        int col = sc.nextInt();
        xunhuan(row,col);



        //2. 完成算数运算, 1个方法带有3个参数 num1, num2, +-*/
        //带有返回值, 接受返回值后输出
        //提示：如果匹配的符号是“+-*/”以外的，则提示符号有误，直接返回-1标识即可
        System.out.println("\n==============第2题==============\n");
        System.out.print("请输入第一个数：");
        double num1 = sc.nextInt();
        System.out.print("请输入第二个数：");
        int num2 = sc.nextInt();
        System.out.print("请输入+-*/：");
        char sign = sc.next().charAt(0);
        System.out.println("结果："+operation(num1,num2,sign));

        //3、使用方法完成计算n到1的和,并返回到main方法中, n是大于1的数
        System.out.println("\n==============第3题==============\n");
        System.out.print("计算1-n的和，请输入n：");
        int n3 = sc.nextInt();
        System.out.println("求和为："+qiuhe(n3));

    }

    public static int qiuhe(int n){
        int sum = 0;
        for (int i = 2; i <= n; i++) {
             sum+=i;
        }
        return sum;
    }

    public static double operation(double a,int b,char c){
        switch (c){
            case '+':
                return a+b;
            case '-':
                if (a>b){return a-b;}
                else {return b-a;}
            case '*':
                return a*b;
            case '/':
                if (b==0){
                    System.out.println("除数不能为0！");
                    break;
                }else {
                    return a/b;
                }
            default:
                System.out.println("符号有误！");break;
        }

        return -1;
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
