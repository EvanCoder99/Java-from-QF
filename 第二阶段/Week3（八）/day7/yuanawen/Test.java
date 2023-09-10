package day7.yuanawen;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DaoImpl di = new DaoImpl();
        StudentService ss = new StudentService();
        do {
            System.out.println("1、添加  2、查询  3、退出");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    Student stu = new Student(1, "zs", 18, "101");
                    ss.pandaun(stu);
                    break;
                case 2:
                    List<Student> list = di.query();

                    System.out.println(list);
                    break;
                case 3:
                    System.out.println("退出");
                    return;
                default:
                    System.out.println("输入有误");
                    break;
            }
        }while (true);
    }
}
