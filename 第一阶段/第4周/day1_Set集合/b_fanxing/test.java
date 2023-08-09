package week4.day1_Set.b_fanxing;

import java.util.ArrayList;
import java.util.List;

//通过集合存储自定义对象，引出泛型
//需求：存了自定义对象后，循环遍历取出属性，假设此时存了一个非学生类型，就会报错类不匹配，可以用instanceof或者getcalss判断
//使用泛型的好处：
//1、更安全（不用强转，不用判断是否同类）
//2、约束了类型，更规范
//3、使程序更健壮
class Student{
    String name;

    public Student(String name) {
        this.name = name;
    }
}
public class test {
    public static void main(String[] args) {
//        List l = new ArrayList();
        List<Student> l = new ArrayList<>();
        l.add(new Student("小名同学"));
        l.add(new Student("阿衰同学"));
//        l.add("张三丰");//规避了存储其他类型
//        for (Object o : l) {
//            Student s = (Student) o;
        for (Student o : l) {
            System.out.println(o.name);
        }
    }
}
