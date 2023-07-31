package yuanawen;

import java.util.Arrays;
import java.util.Random;

public class yuanawen {
    public static void main(String[] args) {
        //1.	生成10个75-100之间(包含75和100)的随机整数，将其存放到数组中，并遍历输出数组的数据（10分）
        Random random = new Random();
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(26)+75;
            System.out.print(a[i] +" ");
        }

        //2.	求该数组的数据之和和平均数（平均数保留两位小数点）（10分）
        System.out.println("\n=============2=============");
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum+=a[i];
        }
        System.out.printf("\n数组数据之和的平均数为%.2f",(sum/a.length));

        //3.系统自带sort排序
        System.out.println("=============3=============");
        Arrays.sort(a);
        System.out.println("\n"+Arrays.toString(a));


    }
}

