package week5.day4_Reflect.dayWork;

import java.lang.reflect.Field;

class Computer{
    String brand;
}
class Phone{
    String brand;
}
class Factory{
    public static <T> T getObject(Class<T> c,String name) throws Exception {
        Field field = c.getDeclaredField("brand");
        field.setAccessible(true);
        T t = c.newInstance();
        field.set(t,name);
        return t;
    }
}
public class test2 {
    public static void main(String[] args) throws Exception {
        //2. 有一个电脑类和手机类都有一个brand属性,在工厂类的静态方法中,传入反射对象及属性值,灵活获取到对应的实体对象，返回的对象中包含属性值
        Computer lx = Factory.getObject(Computer.class, "联想");
        Phone hw = Factory.getObject(Phone.class, "华为");
        System.out.println("电脑："+lx.brand);
        System.out.println("手机："+hw.brand);

    }
}
