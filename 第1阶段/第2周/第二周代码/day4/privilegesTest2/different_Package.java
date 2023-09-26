package week2.day4.privilegesTest2;

import week2.day4.privilegesTest.test;

public class different_Package {
    public static void main(String[] args) {
        test t2 = new test();
        //System.out.println(t2.name); //私有权限，在不同包无继承关系中不能使用
        //System.out.println(t2.age); //默认权限，在不同包无继承关系中不能使用
        //System.out.println(t2.sex); //保护权限，在不同包无继承关系（不是子类）中不能使用
        System.out.println(t2.love); //公开权限，在不同包无继承关系中可以使用
    }
}

