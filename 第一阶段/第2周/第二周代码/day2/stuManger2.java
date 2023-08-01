package week2.day2;

import java.util.Scanner;

public class stuManger2 {
    public static void main(String[] args) {
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

}
