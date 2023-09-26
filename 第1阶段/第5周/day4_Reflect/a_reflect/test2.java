package week5.day4_Reflect.a_reflect;

import java.lang.reflect.Method;

class Student{
    public void hello(String name, int age) {
        System.out.println("姓名："+name+"年龄："+age);
    }
}
public class test2 {
    public static void main(String[] args) throws Exception {
        //类对象调用方法：
        //1、获取类对象
        Class c1 = Student.class;
        //2、获取Method对象
        Method method = c1.getMethod("hello", String.class, int.class);
        //3、调用invoke方法
        method.invoke(c1.newInstance(),"zs",33);
    }
}
