package week5.day1_IOStream.c_buffer;

import org.junit.Test;

import java.io.*;

class Person implements Serializable {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class test2 {
    @Test   //对象流的写
    public void outTest() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));

//        oos.writeObject("zs");
        //存自定义对象
        oos.writeObject(new Person("zs", 25));
        oos.writeObject(new Person("ww", 125));
        oos.writeObject(new Person("ls", 55));
        oos.close();
    }

    @Test
    public void inTest() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));

//        String s = (String) ois.readObject();

        //去自定义对象
//        Person p = (Person) ois.readObject();
//        System.out.println(p);
//        ois.close();
        Object o = null;
        try {
            while (true) {
                System.out.println(ois.readObject());
            }
        } catch (Exception e) {
        } finally {
            ois.close();
        }
    }
}
