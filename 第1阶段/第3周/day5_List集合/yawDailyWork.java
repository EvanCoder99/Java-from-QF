package week3.day5;

import java.util.*;

public class yawDailyWork {


    public static void main(String[] args) {
        //1、创建多个Student对象，使用集合Collection进行保存，删除一个，遍历输出，再清空后，判断是否为空。
//        Collection c = new ArrayList();
//        c.add(new Student("a"));
//        c.add(new Student("b"));
//        c.add(new Student("c"));
//
//        //System.out.println(c.contains(new Student("b")));
//        System.out.println(c.remove(new Student("b")));
//        for (Object o : c) {
//            System.out.println(o);
//        }
//        c.clear();
//        System.out.println("是否为空："+c.isEmpty());


        //2、创建多个Student对象，使用集合List保存，实现类为ArrayList，进行添加、以下标添加、以下标获取对象并输出，以下标删除，以下标修改值。
        List l = new ArrayList();
        l.add(new Student("a"));
        l.add(1,new Student("b"));
        l.add(new Student("c"));
        System.out.println("下标为0的元素："+l.get(0));
        l.remove(1);
        System.out.println("删除下标为1："+l);
        l.set(1,"修改");
        System.out.println("修改下标为1："+l);
        System.out.println("================");

        //3、创建多个Student对象，使用集合List保存，实现类为LinkedList，进行添加、以下标添加、以下标获取对象并输出，以下标删除，以下标修改值。
        List ll = new LinkedList();
        ll.add(new Student("a"));
        ll.add(1,new Student("b"));
        ll.add(new Student("c"));
        System.out.println("下标为0的元素："+ll.get(0));
        ll.remove(1);
        System.out.println("删除下标为1："+ll);
        ll.set(1,"修改");
        System.out.println("修改下标为1："+ll);
        System.out.println("================");

        //4、LinkedList独有方法：addLast/addFirst/removeFirst/removeLast等方法的调用
        //提示：LinkedList的独有方法，使用面向对象方式做
        LinkedList ll2 = new LinkedList();
        ll2.add("google");
        ll2.add("edge");
        ll2.add("firefox");
        //addLast--在头部添加元素
        ll2.addFirst("头部");
        ll2.addLast("尾部");
        ll2.removeFirst();
        ll2.removeLast();
        System.out.println(ll2);


    }
}
class Student{
    String name;
//    @Override //IDEA自动生成
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return Objects.equals(name, student.name);
//    }

    public Student(String name) {
        this.name = name;
    }

    public boolean equals(Object o){
        if (o instanceof Student){
            Student s = (Student) o;
            return this.name.equals(s.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}