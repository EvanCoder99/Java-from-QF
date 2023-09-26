package week2.day2;

import java.util.Scanner;

public class stuManager {
    public static void main(String[] args) {
        String[] names = new String[50];  //动态赋值--全是null
        do {
            System.out.println("请输入你的操作标记：1.添加，2.查询，3.退出");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            switch(num) {
                case 1:
                    System.out.print("请添加学员姓名:");
                    String name = sc.next();
                    add(names,name);  //添加功能
                    break;
                case 2:
                    query(names);    //查询功能
                    break;
                case 3:
                    System.out.println("退出");
                    return;
            }
        }while(true);
    }
    private static void query(String[] names) { //查询功能
        for(int i=0;i<names.length;i++) {//循环50次
            if(names[i]==null) {
                return;
            }
            System.out.println(names[i]);
        }
    }

    private static void add(String[] names, String name) { //添加功能
        for(int i=0;i<names.length;i++) {
            //注意：String为null不能调方法，否则报错
            if(names[i]==null) { //为null，则直接存储；判断null可以使用==
                names[i]=name;
                System.out.println("添加成功~！");
                return;
            }
            if(names[i].equals(name)) {//判断名字在数组中是否存在，注意引用类型不要用==
                System.out.println("该姓名已存在！！！");
                return;
            }
        }
    }

}
