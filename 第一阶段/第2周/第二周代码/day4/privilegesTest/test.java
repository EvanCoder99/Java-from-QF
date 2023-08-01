package week2.day4.privilegesTest;

public class test { //实体类
    private String name;   //私有权限
    int  age;              //default权限
    protected String sex;  //保护权限
    public String love;    //公开权限

    //同一个类——权限测试
    public void eat() {
        System.out.println(name); //私有权限，在本类中可以使用
        System.out.println(age);  //默认权限，在本类中可以使用
        System.out.println(sex);  //保护权限，在本类中可以使用
        System.out.println(love); //公开权限，在本类中可以使用
    }
}

