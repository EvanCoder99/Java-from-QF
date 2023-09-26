package week5.day4_Reflect.a_reflect;

import java.lang.reflect.Field;

class Cat{
    String name;

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + '}';
    }
}
class Dog{
    String name;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Factory{
    public static final int F_CAT = 1;
    public static final int F_DOG = 2;

    public static Dog getDog() {
        return new Dog();
    }

    public static Cat getCat() {
        return new Cat();
    }

    public static Object getObject(int f){
        if (f == F_DOG){
            return new Dog();
        }else if (f == F_CAT){
            return new Cat();
        }else
            return null;
    }

    public static <T> T Object(Class<T> c, String name) throws Exception {
        //获取Field对象
        Field field = c.getDeclaredField("name");
        //给权限，调用私有属性
        field.setAccessible(true);
        //实例化类对象
        T t = c.newInstance();
        //调用set方法进行赋值
        field.set(t,name);
        return t;
    }
}
public class test4 {
    public static void main(String[] args) throws Exception {
        //1、面向对象方式获取对象
        //获取30个对象，需要30个方法，代码冗余
        Dog dog = Factory.getDog();
        Cat cat = Factory.getCat();

        //2、传入标记获取对象
        //违背了ocp原则，维护性太差，新增类需要新增多个判断和返回值，耦合性太强
        Cat c = (Cat) Factory.getObject(Factory.F_CAT);
        Dog d = (Dog) Factory.getObject(Factory.F_DOG);

        //3、反射用法
        Dog dd = Factory.Object(Dog.class, "旺财");
        Cat cc = Factory.Object(Cat.class, "加菲猫");
        System.out.println(dd+"--"+cc);
    }
}
