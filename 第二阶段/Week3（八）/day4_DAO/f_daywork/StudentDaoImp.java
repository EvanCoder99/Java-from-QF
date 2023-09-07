package day4_DAO.f_daywork;

import java.util.List;
import java.util.Scanner;

public class StudentDaoImp {
    public static void main(String[] args) {
        /*
           什么是orm？
           答：是对象关系映射，其中O是java对象实体，R是关系型数据库，M是映射，是一种为了解决面向对象与关系数据库存在的互不匹配的现象的技术
         */

        /*
        create table student(
            id int primary key auto_increment,
            name varchar(10),
            age int(3)
        )
        */

        /*
        2. 编写StudentDao层,增删改查
          2.1 创建表结构: student表中有id 主键自增长,name 字符串类型 ,age int类型
          2.2 创建Student实体类：表字段与实体属性一一对应
          2.3 抽取工具类及配置文件
          2.4 创建StudentDao完成JDBC
        */

        Scanner sc = new Scanner(System.in);
        StudentDao stuDao = new StudentDao();

        do {
            System.out.println("请输入编号：1.添加 2.修改 3.删除 4.查询 5.退出");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    Student s = new Student(1, "坤坤", 18);
                    System.out.println("添加记录："+stuDao.add(s));
                    break;
                case 2:
                    s = new Student(2,"鸡哥",23);
                    System.out.println("修改记录："+stuDao.update(s));
                    break;
                case 3:
                    System.out.print("输入要删除的学号：");
                    int id = sc.nextInt();
                    System.out.println("删除记录："+stuDao.deleteById(id));
                    break;
                case 4:
                    List<Student> list = stuDao.queryAll();
                    System.out.println(list);
                    break;
                case 5:
                    System.out.println("已退出！");
                    return;
                default:
                    System.out.println("输入有误");
                    break;
            }

        }while (true);
    }
}
