package week1.day02;

import java.util.Scanner;

public class num1 {
    public static void main(String[] args) {

        /*
        1,张三的ava成绩，大于80分，全班鼓掌
        2.输入张三的Java和php成绩，都大于80分，全班鼓掌，否则鼓励
        3.考试成绩评测，大于等于80分良好，大于等于60分并小于80分中等，小于60分多加努力
        4.输入会员积分及购物金额，
        根据积分的不同享受不同的折扣，并输出结账金额
        X<2000  9折
        2000≤×<4000 8折
        4000≤×<8000 7折
        X≥8000      6折
        5,输入数字，输出今天星期几
        1---星期1 switch
         */

        //1,张三的ava成绩，大于80分，全班鼓掌
        int a = 88;
        if (a>80)
            System.out.println("1、张三的java成绩>80封，全班鼓掌");

        //2.输入张三的Java和php成绩，都大于80分，全班鼓掌，否则鼓励
        Scanner sc = new Scanner(System.in);
        System.out.println("\n2、请输入张三的java 和 php 成绩：");
        int java = sc.nextInt();
        int php = sc.nextInt();
        if (java > 80 && php > 80 )
            System.out.println("全班鼓掌！");
        else
            System.out.println("全班鼓励");

        //3.考试成绩评测，大于等于80分良好，大于等于60分并小于80分中等，小于60分多加努力
        System.out.println("\n3、考试测评，输入成绩：");
        int score = sc.nextInt();
        if (score >= 80)
            System.out.println("良好");
        if (score>=60 && score <80)
            System.out.println("中等");
        if (score<60)
            System.out.println("多加努力");

        //4、        4.输入会员积分及购物金额，
        //        根据积分的不同享受不同的折扣，并输出结账金额
        //        X<2000  9折
        //        2000≤×<4000 8折
        //        4000≤×<8000 7折
        //        X≥8000      6折
        System.out.println("请输入会员积分与购物金额");
        int vip = sc.nextInt();double money = sc.nextDouble();
        if (vip<2000)
            System.out.println("您享九折，折后："+money*0.9);
        else if (vip<4000)
            System.out.println("您享八折，折后："+money*0.8);
        else if (vip<8000)
            System.out.println("您享七折，折后："+money*0.7);
        else if (vip > 8000)
            System.out.println("您享六折，折后："+money*0.6);
        else if(vip<0)
            System.out.println("输入有误！");

        //5,输入数字，输出今天星期几  1---星期1 switch
        System.out.println("5、输入数字，输出今天星期几");
        int week = sc.nextInt();
        switch (week){
            case 1:
                System.out.println("周一");break;
            case 2:
                System.out.println("周二");break;
            case 3:
                System.out.println("周三");break;
            case 4:
                System.out.println("周四");break;
            case 5:
                System.out.println("周五");break;
            case 6:
                System.out.println("周六");break;
            case 7:
                System.out.println("周日");break;
            default:
                System.out.println("输入有误");
        }

        }
    }
