package week2.day1;

import com.sun.javafx.image.BytePixelSetter;

import java.util.Arrays;
import java.util.Scanner;

public class yawHW {
    public static void main(String[] args) {
        //1、创建整数数组，并进行赋值，长度为5（备注好数组的组成、标识符、长度、下标，数据类型）
        System.out.println("==================");
        int[] a1 = {1,2,3,4,5};
        System.out.println("数组的组成："+ Arrays.toString(a1));
        System.out.println("数组的标识符为：a1");
        System.out.println("数组的长度为："+a1.length);
        System.out.println("数组的下标为：0-4");
        System.out.println("数组的数据类型为：int");
        System.out.println("==================");

        //2、使用3种方式创建整数数组，长度为5。
        int[] a2_1 = new int[5];    //动态赋值
        int[] a2_2 = {1,2,3,4,5};   //静态赋值
        int[] a2_3;                 //先声明，再创建
        a2_3 = new int[5];


        //3、1个班5人java成绩，创建浮点数数组，使用循环输入、再找到成绩最高的分数，并输出
        Scanner sc = new Scanner(System.in);
        float[] f3 = new float[5];
        float max = 0;
        int i = 0;

        while (true){
            System.out.print("请输入第"+(i+1)+"个人的Java成绩：");
            float f3_Stu = sc.nextFloat();

            if(f3_Stu > 0 && f3_Stu < 100){
                if (max<f3[i])
                    max = f3[i];
                i++;
            }else
                System.out.println("成绩输入有误，请重新输入");
            if(i==5)
                break;
        }

        System.out.println("==================");

        //4、创建数组长度为5，然后长度扩容为10
        //系统提供扩容
        //方式一：System.arraycopy(旧数组，旧下标，新数组，新下标，旧数组长度)，返回：无返回
        int[] a4 = new int[5];
        int[] a4_new = new int[5+5];
        System.arraycopy(a4,0,a4_new,0,a4.length);
        System.out.println(Arrays.toString(a4_new));

        //方式二：Arrays.copyOf(旧数组，新数组长度)，返回：新数组
        int[] a4_new2 = Arrays.copyOf(a4,10);
        a4_new2[1] = 2;
        System.out.println(Arrays.toString(a4_new2));

        //方式三：
        int[] a4_new3 = new int[a4.length+5];
        for (int j = 0; j < a4.length; j++) {
            a4_new3[j] = a4[j];
        }
        a4_new3[2] = 3;
        System.out.println(Arrays.toString(a4_new3));

        System.out.println("==================");

        //5、1个班5人java成绩，创建方法，参数为数组，计算平均分（方法1），然后所有学员50分以下+10分，50分及以上的加5分，并将结果数组返回（方法2），接受后输出
        double[] d5 = new double[]{50,10,90,30,20};
        System.out.println("平均分为："+f1(d5));
        f2(d5);
        System.out.println(Arrays.toString(d5));


        //自定义MyArrays.toSring(数组参数)的方法实现
        //int[] a = {1,3,5};
        //打印结果-->[1,3,5]
        System.out.println("==================");
        int[] a6 = new int[]{1,2,3};
        toString(a6);


    }
    public static String toString(int[] a){
        String s= null;
        for (int i = 0; i < a.length; i++) {
            if (i == 0)
                System.out.print("["+a[0]+',');
            else if (i == a.length-1)
                System.out.print(a[a.length-1]+"]");
            else
                System.out.print(a[i]+",");
        }
        return s;
    }

    public static double f1(double[] a){
        int sum=0,avg= 0;
        for (int i = 0; i < a.length; i++)
            sum+=a[i];
        return avg = sum/a.length;
    }
    public static double[] f2(double[] a){
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 50 && a[i]<100)
                a[i]+=5;
            else if(a[i]<=50 && a[i] >0)
                a[i]+=10;
            else
                System.out.println("成绩输入有误");
        }
        return a;
    }
}
