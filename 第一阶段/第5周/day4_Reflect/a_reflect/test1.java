package week5.day4_Reflect.a_reflect;

import java.lang.reflect.Field;

class Person{
    private String name;
    private int age;
}
public class test1 {
    public static void main(String[] args) throws Exception {
        //1、获取类对象
        Class c1 = Person.class;
        //2、获取Field对象
        Field field = c1.getDeclaredField("name");
        //3、给权限，调用私有属性
        field.setAccessible(true);
        //4、实例化类对象
        Object o = c1.newInstance();
        /*Person zs1 = new Person();
        Person zs2 = (Person) c1.newInstance();*/
        //5、file调用set方法进行赋值
        field.set(o,"张三丰");

        //5、验证数据是否存进去：get
        System.out.println(field.get(o));
//        System.out.println(((Person)o).name);
    }
}
