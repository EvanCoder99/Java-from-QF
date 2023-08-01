package week2.day2;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class yawHW {
    public static void main(String[] args) {
        //1、使用doub1e类型可变长参数，接收实参变量，并进行打印
        print(1, 0.9, 22, 88.9, 74, 6);

        //2、数组的排序，创建长度为5的数组，并循环输入值，再进行排序：
        //2.1.冒泡排序
        //2.2.选择排序
        //2.3.Arrays.sort3种方式
        int[] a2 = new int[5];
        for (int i = 0; i < a2.length; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入第"+(i+1)+"个数：");
            int num = sc.nextInt();
            a2[i] = num;
        }
        print2(a2); //数组打印
        //冒泡
        for (int i = 0; i < a2.length; i++) {
            for (int j = 0; j < a2.length-1-i; j++) {
                if (a2[j] > a2[j+1]){
                    int t = a2[j];
                    a2[j] = a2[j+1];
                    a2[j+1] = t;
                }
            }
        }
        System.out.print("冒泡排序后");
        print2(a2);

        //选择排序
        for (int i = 0; i < a2.length-1; i++) {
            for (int j = i+1; j < a2.length; j++) {
                if (a2[i] > a2[j]){
                    int t = a2[j];
                    a2[j] = a2[i];
                    a2[i] = t;
                }
            }
        }
        System.out.print("选择排序后");
        print2(a2);

        //Arrays.sort
        Arrays.sort(a2);
        System.out.print("sort排序后");
        System.out.println(Arrays.toString(a2));


        //3、使用二维数组，保存3个班，每齐班5人的成绩，并进行输出
        int[][] a3 = new int[3][5];
        for (int i = 0; i < a3.length; i++) {
            for (int j = 0; j < a3[i].length; j++) {
                System.out.print("请输入第"+(i+1)+"个班，第"+(j+1)+"人的成绩：");
                Scanner sc = new Scanner(System.in);
                int score = sc.nextInt();
                a3[i][j] = score;
            }
        }
        print2(a3);

        //4.将学员管理系统的删除和修改完成;
        String[] s = new String[50];
        String name;
        do {
            System.out.println("请输入你的操作标记：1.添加，2.查询，3.修改，4.删除，5.退出");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            switch (num){
                case 1:
                    System.out.print("请添加学员姓名:");
                    name = sc.next();
                    add(s,name);  //添加功能
                    break;
                case 2:
                    query(s);    //查询功能
                    break;
                case 3:
                    System.out.print("请输入修改的学员姓名:");
                    name = sc.next();
                    alter(s,name);
                    break;
                case 4:
                    System.out.print("请输入删除的学员姓名:");
                    name = sc.next();
                    del(s,name);
                    break;
                case 5:
                    System.out.println("退出");
                    return;
                default:
                    System.out.println("输入有误");
                    break;
            }
        }while (true);

    }

    private static void query(String[] s) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] == null)
                break;
            System.out.println(s[i]);
        }
    }

    private static void add(String[] s, String name) {

        for (int i = 0; i < s.length; i++) {
            if (s[i] == null){
                s[i] = name;
                System.out.println("添加成功");
                return;
            }
            if (s[i].equals(name)){
                System.out.println("改姓名已经存在");
                return;
            }
        }
    }

    public static void del(String[] s,String name){
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals(name)){     //如果数组中有name
                for (int j = i; j < s.length-1; j++) {
                    s[j] = s[j+1];
                }
                System.out.println("删除成功！");
                return;
            }
        }
        System.out.println("该姓名不存在");
    }

    public static void alter(String[] s, String name){
        for (int i = 0; i < s.length; i++) {
            while (s[i].equals(name)){
                System.out.print(s[i]+"已存在，修改为：");
                Scanner sc = new Scanner(System.in);
                s[i] = sc.next();
                System.out.println("修改成功");
                return;
            }
        }
        System.out.println("该姓名不存在");
    }


    public static void print(double ... d){
        for (int i = 0; i < d.length; i++) {
            System.out.print(d[i]+" ");
        }
    }

    public static void print2(int[] a2){
        System.out.print("数组为：[");
        for (int i = 0; i < a2.length; i++) {
            System.out.print(+a2[i]+" ");
        }
        System.out.print("]\n");
    }
    public static void print2(int[][] a2){
        System.out.println("数组为：");
        for (int i = 0; i < a2.length; i++) {
            for (int j = 0; j < a2[i].length; j++) {
                System.out.print(a2[i][j]+" ");
            }
            System.out.println();
        }
    }
}
