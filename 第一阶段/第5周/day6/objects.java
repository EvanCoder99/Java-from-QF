package week5.day6;

import java.io.*;

class Student implements Serializable {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class objects {
    public static void main(String[] args) throws Exception {
        //创建Java对象
        Student stu = new Student("张三", 26);

        //序列化，包装流，给个文件路径
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students"));

        //序列化对象
        oos.writeObject(stu);

        //刷新
        oos.flush();

        //关闭
        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students"));

        try {
//            System.out.println(ois.readObject());
            String o = (String) ois.readObject();
            System.out.println(o);
        } catch (Exception e) {
        } finally {
            ois.close();
        }

    }
}
