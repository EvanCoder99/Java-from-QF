package week3.day3.b_ObjectClass.Object;

class Man{
}
class WoMan{
    String name;
    int  age;
    public WoMan(String name,int age) {
        this.name = name;
        this.age  = age;
    }
    @Override  //当前类重写的hashCode，里面获取的是属性的hash值
    public int hashCode() {
        //name.hashCode():String类型的hashCode：用于比较内容是否一致，内容相同则返回相同哈希值
        //String类型的hashCode是重写了Object类的hashCode，比较的是字符串的内容，而非地址
        return name.hashCode()+age;
    }
}
public class HashCode {
    public static void main(String[] args) {
        System.out.println(new Man().hashCode()); //366712642
        System.out.println(new Man().hashCode()); //1829164700

        System.out.println("字符串的hashCode："+"凤姐".hashCode());//字符串的hashCode：672876
        System.out.println("字符串的hashCode："+"凤姐".hashCode());

        System.out.println(new WoMan("凤姐", 1).hashCode()); //672906
        System.out.println(new WoMan("凤姐", 1).hashCode());


    }
}
