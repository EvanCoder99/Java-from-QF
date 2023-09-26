package day1_Servlet.c_Test.c_Dao;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dao dao = new Dao();
        do {
            System.out.println("请输入操作编号：1.添加 2.修改 3.删除 4.查询 5.退出");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    Person p = new Person(1, "1", 18, new Date(), "123@qq.com");
                    System.out.println("添加记录："+dao.add(p));
                    break;
                case 2:
                    p = new Person(3, "ls", 40, new Date(), "123@qq.com");
                    System.out.println("修改记录："+dao.update(p));
                    break;
                case 3:
                    System.out.println("删除记录："+dao.deleteById(2));
                    break;
                case 4:
                    List<Person> list = dao.query();
                    System.out.println(list);
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
}
