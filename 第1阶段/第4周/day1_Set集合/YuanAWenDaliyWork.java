package week4.day1_Set;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class YuanAWenDaliyWork {
    public static void main(String[] args) {
        //1.将TreeSet存两个属性对象课堂案例中的比较方式进行变更，先按年龄的升序比较，如果年龄相同，则按姓名的降序比较
        Set<Animal> set = new TreeSet<Animal>();
        set.add(new Animal("dog",4));
        set.add(new Animal("cat",1));
        set.add(new Animal("bird",1));
        set.add(new Animal("tiger",25));
        System.out.println(set);

        //2.自己重写对象Student的hashCode和equals方法,保证在set集合中能正确判断是否重复
        Set<Student> set2 = new HashSet<>();
        set2.add(new Student("小明",12));
        set2.add(new Student("小黄",10));
        set2.add(new Student("小明",12));
//        System.out.println(set2);

        //3、两个HashSet集合中存储字符串元素，集合A:"zs","ls"   集合B:"zs","ww",最终使用新的hashSet集合得到交集的“zs”
        Set<String> A = new HashSet<>();
        A.add("zs");
        A.add("ls");
        Set<String> B = new HashSet<>();
        B.add("zs");
        B.add("ww");
        Set<String> C = new HashSet<>();
        for (String a : A) {
            for (String b : B) {
                if (a.equals(b))
                    C.add(a);
            }
        }
        System.out.println("交集："+C);

        //4、创建一个Student类，有成员变量name和分数(Double类型)。如果两个学生对象的姓名和分数一样视为同一个学生，先按姓名的降序排，如果姓名相同，则按分数的升序排；提示：--分数属性使用Double，可使用compareTo方法
        Set<Studen4> s4 = new TreeSet<>();
        s4.add(new Studen4("aa",24.6));
        s4.add(new Studen4("aa",24.6));
        s4.add(new Studen4("bb",61.7));
        s4.add(new Studen4("cc",0.9));
        s4.add(new Studen4("cc",99.9));
        System.out.println(s4);
    }
}

class Studen4 implements Comparable<Studen4>{
    String name;
    Double score;

    public Studen4(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Studen4 o) {
        //如果两个学生对象的姓名和分数一样视为同一个学生，先按姓名的降序排，如果姓名相同，则按分数的升序排
        if(this.name.compareTo(o.name) == 0)
            return this.score.compareTo(o.score);
        return o.name.compareTo(this.name);//降序
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studen4 studen4 = (Studen4) o;
        return Objects.equals(name, studen4.name) && Objects.equals(score, studen4.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return "Studen4{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
//说明：存储自定义对象，自定义类要么实现Comparable接口；要么使用比较器
class Animal implements Comparable<Animal> {
    String species;
    int age;

    public Animal(String species, int age) {
        this.species = species;
        this.age = age;
    }

    //规则：先按年龄的升序比较，如果年龄相同，则按姓名的降序比较
    @Override
    public int compareTo(Animal o) {
        if (this.age == o.age){
            return o.species.compareTo(this.species);
        }
        return  this.age-o.age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", age=" + age +
                "}";
    }
}