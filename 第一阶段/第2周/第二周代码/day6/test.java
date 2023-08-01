package week2.day6;

public class test {
    public static void main(String[] args) {
        Person[] p = new Person[3];
        p[0] = new Teacher("李老师",32,3400);
        p[1] = new Strudent("小敏",15,66.8);
        p[2] = new Strudent("网二",16,99.0);
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i].say());
            if (p[i] instanceof Strudent){
                Strudent strudent = (Strudent) p[i];
                ((Strudent) p[i]).work();
                System.out.println("------");
            } else if (p[i] instanceof Teacher) {
                ((Teacher) p[i]).gzy();
                System.out.println("------");
            }
        }

    }
}
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String say(){
        return name +"\t"+ age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Strudent extends Person{
    double score;

    public Strudent(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }
    public void work(){
        System.out.println(getName()+" 正在写作业");
    }

    @Override
    public String say() {
        return super.say() + "成绩：" + score;
    }
}
class Teacher extends Person{
    int salary;

    public Teacher(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    public void gzy(){
        System.out.println(getName()+ " 正在上课");
    }
    @Override
    public String say() {
        return super.say() + "薪水：" + salary;
    }
}