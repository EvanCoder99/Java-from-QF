package day1_Servlet.WeekTest;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        userDaoImpl dao = new userDaoImpl();
        do {
            System.out.println("1、添加  2、修改  3、查询  4、删除  5、退出");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    User user = new User(1, "ws", "123");
                    System.out.println("添加记录："+dao.add(user));
                    break;
                case 2:
                    user = new User(2, "ws", "123");
                    System.out.println("修改记录："+dao.update(user));
                    break;
                case 3:
                    System.out.println("1、查询所有  2、根据ID查询");
                    int key = sc.nextInt();
                    if (key == 1){
                        System.out.println(dao.queryAll());
                    }else if (key == 2){
                        System.out.println("输入ID：");
                        int id = sc.nextInt();
                        System.out.println(dao.queryByID(id));
                    }else {
                        System.out.println("输入有误");
                    }
                    break;
                case 4:
                    System.out.println("1、根据姓名删除  2、根据ID删除");
                    int key2 = sc.nextInt();
                    if (key2 == 1){
                        System.out.println("姓名删除记录："+dao.delete("zs"));
                    }else if (key2 == 2){
                        System.out.println("输入ID：");
                        int id = sc.nextInt();
                        System.out.println("ID删除记录："+dao.delete(id));
                    }else {
                        System.out.println("输入有误");
                    }
                    break;
                case 5:
                    System.out.println("已退出");
                    return;
                default:
                    System.out.println("输入有误");
                    break;
            }
        }while (true);

    }
}
