package week1.day02;

import java.util.Scanner;

public class num5 {
    public static void main(String[] args) {
        boolean key;
        System.out.print("请输入会员卡号（4位数）：");
        Scanner sc = new Scanner(System.in);
        int vipCard = sc.nextInt();
        if (vipCard < 10000 && vipCard >0){
            int q = vipCard/1000;
            int b = vipCard/100%10;
            int s = vipCard/10%10;
            int g = vipCard%10;
            int sum = q+b+s+g;
            System.out.println("数字之和为："+sum);
            if ((q+b+s+g)%2==0) {
                key = false;
                System.out.println("结果：" + key + "\t很抱歉，你不是幸运用户！");
            }else {
                key = true;
                System.out.println("结果：" + key + "\t恭喜，你是幸运用户！");
            }
            System.out.println();
        }else System.out.println("输入有误");
    }
}
