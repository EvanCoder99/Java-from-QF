package week5.day1_IOStream.dayWork;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class People implements Serializable {
    String name;
    int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class test3 {

    //3.使用对象流,写出集合，集合封装多个对象的存储，并使用对象流读取出来
    @Test
    public void outTest() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("word3.txt"));
        List<People> list = new ArrayList<>();
        list.add(new People("老人", 85));
        list.add(new People("大人", 35));
        list.add(new People("小孩", 15));

        oos.writeObject(list);
        oos.close();
    }

    @Test
    public void inTest() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("word3.txt"));

        try {
            while (true){
                System.out.println(ois.readObject());
            }
        } catch (IOException e) {
        }finally {
            ois.close();
        }
    }
}
