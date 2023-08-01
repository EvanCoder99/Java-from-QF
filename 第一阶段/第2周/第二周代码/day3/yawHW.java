package week2.day3;

public class yawHW {
    public static void main(String[] args) {

        //1.创建狗类，定义属性（名称、性别、岁数、颜色、品种）和方法（叫、玩、睡）,实例化狗类，输出属性，运行狗类方法
        Dog dog = new Dog("大壮","公狗",3,"黄色","拉布拉多狗");
        dog.cry();
        dog.paly();
        dog.sleep();

        //2。创建猫类，定义属性（名称、性别、岁数、颜色、品种）和方法（叫、玩、撒娇），实例化3个不同的猫对象，输出3个猫对象的属性，并运行他们的方法
        Cat cat1 = new Cat();
        cat1.name = "傻猫";
        Cat cat2 = new Cat();
        cat2.special = "暹罗猫";
        Cat cat3 = new Cat();
        cat3.color = "黑白色";
        System.out.println("猫的名字："+cat1.name);
        cat1.cray();
        System.out.println("猫的品种："+cat2.special);
        cat2.play();
        System.out.println("猫的颜色："+cat3.color);
        cat3.pout();

        //3.定义学生类：
        // - 属性：姓名(name)、年龄(age)、性别(sex)、分数(score)
        // - 方法：打招呼(sayHi) //打印学生所有信息
        //- 创建多个学生对象，为其各个属性赋值，并调用方法
        Stu stu1 = new Stu("赵二麻子","男",18,99.88);
        Stu stu2 = new Stu();
        stu2.name = "乔碧萝";
        stu2.sex = "女";
        stu2.age = 25;
        stu2.score = 33.66;
        stu1.sayHi();
        stu2.sayHi();

        //4.计算器对象 ,  使用方法重载，设置方法2个数加法，3个数加法，4个数加法
        Calculator cal = new Calculator();
        System.out.println("总和为："+cal.compute(1,2));
        System.out.println("总和为："+cal.compute(1,2,3));
        System.out.println("总和为："+cal.compute(1,2,3,4));

        //5.-定义老师类:
        // - 属性：姓名(name)、年龄(age)、性别(sex)、部门（deptment）
        // - 方法：sayHi(); //打印老师所有信息
        //-  通过带参构造创建老师对象 ，并调用方法
        Teacher tea = new Teacher("韩顺平","男",45,"哔哩哔哩");
        tea.sayHi();

    }
}

class Teacher {
    String name;
    String sex;
    int age;
    String deptment;

    public Teacher(String name, String sex, int age, String deptment) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.deptment = deptment;
    }

    public void sayHi(){
        System.out.println(name+" "+sex+" "+age+" "+deptment+"向大家问好");

    }
}
class Calculator {
    public int compute(int...nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
             sum+=nums[i];
        }
        return sum;
    }
}

class Stu {
    String name;
    String sex;
    int age;
    double score;

    public Stu() {
    }

    public Stu(String name, String sex, int age, double score) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.score = score;
    }

    public void sayHi(){
        System.out.println(name+" "+sex+" "+age+" "+score+"向大家问好");
    }
}
class Cat{
    String name;
    String sex;
    int age;
    String color;
    String special;

    public void cray(){
        System.out.println(name+"在猫叫");
    }
    public void play(){
        System.out.println(special+"在玩耍");
    }
    public void pout(){
        System.out.println(color+"在撒娇");
    }
}
class Dog {
    String name;
    String sex;
    int age;
    String color;
    String special;

    public Dog() {
    }

    public Dog(String name, String sex, int age, String color, String special) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.color = color;
        this.special = special;
    }

    public void cry(){
        System.out.println(name+color+special+"在狗叫");
    }
    public void paly(){
        System.out.println(name+color+special+"在玩耍");
    }
    public void sleep(){
        System.out.println(name+color+special+"在睡觉");
    }
}