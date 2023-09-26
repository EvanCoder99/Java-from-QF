package week4.day1_Set.b_fanxing;

//泛型接口，一般设置为T（自定义）、E（集合），键值对则使用K、V
interface MyList <T>{//定义了泛型T，在使用时可以约束使用的类型
    void add(T t);
}

//泛型类
class MyArrayList<T> implements MyList<T>{
    @Override
    public void add(T t) {
        System.out.println("模拟集合存元素");
    }
}

//泛型方法
class MyClass{
    public <T> T test(T t) {
        System.out.println("泛型方法");
        return t;
    }
}
public class test2 {
    public static void main(String[] args) {
//        MyArrayList mal = new MyArrayList();          //泛型如果没约束，集合仍然可以随便存储各种类型
        MyArrayList<Integer> mal = new MyArrayList<>(); //使泛型类或者泛型接口的设计，往往约束传参的类型为同一类型
        mal.add(555);
//        mal.add("张三丰");
        mal.add(111);

        new MyClass().test(666); //使用泛型方法
    }
}
