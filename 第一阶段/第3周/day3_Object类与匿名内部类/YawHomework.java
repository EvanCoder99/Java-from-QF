package week3.day3;


public class YawHomework {
    public static void main(String[] args) {
        //1.Object类实现多态的方式有哪些？并给出案例
        //a、传参多态
        use(new Iphone());

        //b、返回值多态
        Object o = YawHomework.getPhone();

        //2.公司招聘微服务架构标准人才,匿名内部类具备该标准，请使用匿名内部类完成
        new Talent(){
            @Override
            public void Recuit() {
                System.out.println("华为公司招聘百万年薪人才--Evan");
            }
        }.Recuit();

        //3.3.实例化两个String对象，调用两次hashCode，返回的值为什么一致？如何做到的。
        //例如：
        //new String("zs").hashCode();
        //new String("zs").hashCode();
        //答：因为String类型的hashCode方法重写了Obejct的hashCode方法，返回的是字符串内容的hashCode值


        //4.实例化两个String对象，调用equals方法进行比较，为什么会返回true？如何做到的。
        //String s1 =new String("zs");
        //String s2 =new String("zs");
        //s1.equals(s2)---true
        //答：因为String类型的equals方法重写了Obejct的equals方法，返回的是字符串内容比较后的布尔值
        //先用instanceof或者getClass判断是否是同类，
        //是的话，则先需要将传来的父类形参，向下转型，然后传来的多态参数的属性和当前对象的属性进行比较，同返回true，异返回false

    }
    public static void use(Object o){
        Iphone i = (Iphone) o;
        i.run();
    }
    public static Object getPhone(){
        return new Iphone();
    }
}
interface Talent{
    void Recuit();
}
class Iphone{
    public void run(){
        System.out.println("手机正在运行");
    }
}