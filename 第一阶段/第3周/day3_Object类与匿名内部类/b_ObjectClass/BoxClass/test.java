package week3.day3.b_ObjectClass.BoxClass;

class Person{
    String name;
    Integer age;
    Character sex;
}
public class test {
    public static void main(String[] args) {
        //装箱：将基本类型转为包装类型
        //方式一：
        Integer a = new Integer(1);
        //方式二：类名调用静态方法
        a = Integer.valueOf(2);

        //拆箱：将包装类转为基本类型
        int b = a.intValue();   //2

        //自动装箱：本质还是手动装，系统自动做了
        Integer c = 3;
        //自动拆箱
        int d = c;
        System.out.println(d);

        //字符串与其他类型的转换
        //1、其他类型-->字符串
        String e = 1+"";

        String f = "33";
        int g = Integer.parseInt(f);
    }
}
