package week5.day4_Reflect.dayWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

class Person3{}
class Factory3{
    public static <T> T getObject(Class<T> c) throws Exception {
        return c.newInstance();
    }
}
public class test3 {
    public static void main(String[] args) throws Exception {
        //3、配置文件中user.properties中有一组键值对为: key=xx.xx.xx.Person
        //请加载配置文件后，根据key获取出value，并通过反射机制获取对应的实体对象
        Properties p = new Properties();
        p.load(new FileInputStream("Test6/src/week5/day4_Reflect/dayWork/user.properties"));
        String path = p.getProperty("key");//根据key获取value
        System.out.println(Factory3.getObject(Class.forName(path)));
    }
}
