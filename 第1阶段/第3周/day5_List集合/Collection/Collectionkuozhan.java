package week3.day5.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

class Person{
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

}
public class Collectionkuozhan {
    public static void main(String[] args) {
        //Collection扩展：remove,contains
        //使用Co11ection存储自定义类型，观察移除或包含的操作
        Collection c = new ArrayList();
        c.add(new Person("张三"));
        c.add(new Person("李四"));
        System.out.println(c);//没重写toString，会打印两个person的地址@哈希值

        //contains方法指是否包含指定的元素，内部用equals去比较是否包含，不重写，则使用父类的equals，比较地址，所以为false
        //重写后，往往比较属性
        System.out.println(c.contains(new Person("张三")));//没重写false，重写true

        //如果没重写equals，则不会删除，因为比较的是地址
        System.out.println(c.remove(new Person("张三")));
    }
}
