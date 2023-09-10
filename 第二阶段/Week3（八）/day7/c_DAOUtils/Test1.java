package day7.c_DAOUtils;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PerosnDaoImpl dao = new PerosnDaoImpl();
        do {
             System.out.println("请输入：1、添加  2、修改  3、删除  4、查询  5、ID查询  6、退出");
             int n = sc.nextInt();
             switch (n) {
                 case 1:
                     Person p = new Person(1, "zs", 30, new Date(), "lhp@163.com");
                     System.out.println("添加记录："+dao.add(p));
                     break;
                 case 2:
                     p = new Person(5, "ls", 40, new Date(), "lhp@163.com");
                     System.out.println("修改记录："+dao.update(p));
                     break;
                 case 3:
                     System.out.println("删除记录："+dao.deleteByID(5));
                     break;
                 case 4:
                     List<Person> list = dao.queryAll();
                     System.out.println(list);
                     break;
                 case 5:
                     Person person = dao.queryById(8);
                     System.out.println(person);
                 case 6:
                     System.out.println("退出");
                     return;
                 default:
                     System.out.println("输入有误");
                     break;
             }
         }while (true);
    }
}
