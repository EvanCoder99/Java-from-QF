package week2.day4.privilegesTest;

//同包不同类——权限测试
public class differentClass {
    public static void main(String[] args) {
        test t = new test();
//        System.out.println(t.name); //私有权限，在同包不同类中不能使用
        System.out.println(t.age);   //默认权限，在同包不同类中可以使用
        System.out.println(t.sex);   //保护权限，在同包不同类中可以使用
        System.out.println(t.love);   //公开权限，在同包不同类中可以使用
    }
}
