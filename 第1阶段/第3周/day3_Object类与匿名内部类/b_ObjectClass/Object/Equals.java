package week3.day3.b_ObjectClass.Object;

class Pig{}
class Cat{
    String name;
    int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        //方式一：instanceof()
        if (obj instanceof Cat){
        //方式二：getClass
//         if (){
            Cat cat = (Cat) obj;
            //String的equals重写了，用于比较内容，相同则返回true
            return this.name.equals(cat.name) && this.age == cat.age;
        }else{
            return false;
        }

    }
}
public class Equals {
    public static void main(String[] args) {
        //1.调用Object类的equals
        Pig peiQi = new Pig();
        Pig qiaoZhi = new Pig();
        System.out.println(peiQi == qiaoZhi);
        System.out.println(peiQi.equals(qiaoZhi));

        //2.调用重写equals--比较属性
        Cat c1 = new Cat("黑猫警长", 2);
        Cat c2 = new Cat("黑猫警长", 2);
        System.out.println(c1.equals(c2));
    }
}
