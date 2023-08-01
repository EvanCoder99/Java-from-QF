package week2.day4;

public class yawHW {
    public static void main(String[] args) {
        //1.以面向对象的思想，编写自定义类描述IT从业者。设定属性包括：姓名，年龄，技术方向，工作年限；方法包括：工作
        //   要求: 属性需要进行封装,且年龄需要合理判断
        IT it = new IT();
        it.setName("韩顺平");
        it.setAge(40);
        it.setWorkYear(10);
        it.setTrend("Java高级工程师");
        it.info();

        //2.以面向对象的思想，编写自定义类描述图书信息。设定属性包括：书名，作者，出版社名，价格；方法包括：信息介绍
        //   要求:属性需要进行封装,且价格需要合理判断
        new Book("《平凡的世界》","路遥","人民教育出版社",36.8).info();


        //3.请用面向对象的思想，设计自定义类描述演员和运动员的信息
        //设定 (注意: 属性可以暂时不封装)
        //1)演员类:
        //属性包括：姓名，年龄，性别，毕业院校，代表作
        //方法包括：自我介绍
        //2)运动员类：
        //属性包括：姓名，年龄，性别，运动项目，历史最好成绩
        //方法包括：自我介始
        //要求
        //3)分析演员和运动员的公共成员，提取出父类—人类
        //4)利用继承机制，实现演员类和运动员类
        //5)编写测试类，分别实例化演员类和运动员类对象，并调用属性和方法调用
        new Actor("胡歌","男",38,"上海戏剧学院","仙剑奇侠传").info();
        System.out.println("--------------");
        new Sportsman("苏炳添","男",29,"田径","9.66s").info();

        //4.爷爷拥有一辆老爷车,爸爸有一辆跑车,我有一辆玩具车;请设计编程案例, 并通过'我'的对象调出所有父类的方法
        //要求: 使用super调用方法
        new Son("喔喔奶糖").info();

        //5. 设计一个父子类的案例; 实例化子类对象时, 要求,先调用父类的带参构造; 再调用子类无参构造（第四题已完成）


    }
}

class grandFather{
    public void info(){
        System.out.println("爷爷拥有一辆布加迪威龙");
    }
}
class Father extends grandFather{

    String name;

    public Father(String name) {
        this.name = name;
        System.out.println("父类的Father(String name)被调用~");
    }

    @Override
    public void info(){
        super.info();
        System.out.println("爸爸拥有一辆面包车");
    }
}
class Son extends Father{
    public Son(String name) {
        super(name);
        System.out.println("子类的Son(String name)被调用~");
    }

    @Override
    public void info(){
        super.info();
        System.out.println("我拥有一辆扭扭车");
    }
}

class  Person{
    String name,sex;
    int age;

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void info(){
        System.out.println("我的名字是："+name+"，性别是："+sex+"，年龄是："+age);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Actor extends Person{
    String graduate,represent;

    public Actor(String name, String sex, int age, String graduate, String represent) {
        super(name, sex, age);
        this.graduate = graduate;
        this.represent = represent;
    }

    public String getGraduate() {
        return graduate;
    }

    public void setGraduate(String graduate) {
        this.graduate = graduate;
    }

    public String getRepresent() {
        return represent;
    }

    public void setRepresent(String represent) {
        this.represent = represent;
    }

    @Override
    public void info(){
        super.info();
        System.out.println(" 毕业院校："+graduate+"，代表作："+represent);
    }
}
class Sportsman extends Person{
    String sports,bestGrade;

    public Sportsman(String name, String sex, int age, String sports, String bestGrade) {
        super(name, sex, age);
        this.sports = sports;
        this.bestGrade = bestGrade;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public String getBestGrade() {
        return bestGrade;
    }

    public void setBestGrade(String bestGrade) {
        this.bestGrade = bestGrade;
    }

    @Override
    public void info(){
        super.info();
        System.out.println(" 运动项目："+sports+"，最好成绩："+bestGrade);
    }
}

class Book{
    private String name,author,publish;
    private double price;

    public Book() {
    }

    public Book(String name, String author, String publish, double price) {
        setName(name);
        setAuthor(author);
        setPublish(publish);
        setPrice(price);
    }

    public void info(){
        System.out.println(name+" 作者："+author+" 出版社："+publish+" 价格："+price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price<0)
            System.out.println("价格输入有误~");
        else
            this.price = price;
    }
}
class IT{
    private String name,trend;
    private int age,workYear;

    public void info(){
        System.out.println(name+" "+age+"岁 "+trend+" "+"工作了"+workYear+"年 ");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrend() {
        return trend;
    }

    public void setTrend(String trend) {
        this.trend = trend;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 120 && age >1)
            this.age = age;
        else
            System.out.println("年龄输入有误~");
    }

    public int getWorkYear() {
        return workYear;
    }

    public void setWorkYear(int workYear) {
        this.workYear = workYear;
    }
}