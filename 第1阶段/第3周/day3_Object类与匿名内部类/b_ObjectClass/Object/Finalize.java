package week3.day3.b_ObjectClass.Object;

class Student{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(name + "已经准备销毁");
    }
}
public class Finalize {
    public static void main(String[] args) {
        Student st = new Student("凤姐");

        new Student("刘亦菲");
        System.gc();
    }
}
