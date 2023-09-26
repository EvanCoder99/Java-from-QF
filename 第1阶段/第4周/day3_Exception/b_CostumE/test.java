package week4.day3_Exception.b_CostumE;

public class test {
    public static void main(String[] args) {
        //创建学生对象，属性需要封装，判断姓名长度<6，年龄1-100；
        Student s1 = new Student();
        try {
            s1.setAge(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            s1.setName("zzzzzzzzzzzzz");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("执行到最后");
    }
}
class StuException extends RuntimeException{
    public StuException(String msg){
        super(msg);
    }
}
class Student{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length()>6)
            throw new StuException("姓名出现异常");
        else
            this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age>100 || age<0)
            throw new StuException("年龄出现异常");
        else
            this.age = age;
    }
}