package week2.day4.privilegesTest2;

import week2.day4.privilegesTest.test;

public class different_Package_Extdens extends test {
    //不同包子类中——权限测试
    public void show() {
//        System.out.println(name);  //私有权限，在不同包，子类中不能使用
//        System.out.println(age);   //default权限，在不同包，子类中不能使用
        System.out.println(sex);   //保护权限，在不同包，子类中可以使用（虽然protected在不同包中不能使用，但是因为有继承，子类中可用）
        System.out.println(love);   //公开权限，在不同包，子类中可以使用
    }
}
