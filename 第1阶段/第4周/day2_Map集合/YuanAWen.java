package week4.day2_Map_Excep;

import java.util.*;

public class YuanAWen {
    public static void main(String[] args) {
        //1.向TreeSet集合中加入5个员工的对象，根据员工的年龄（升序）进行排序，若年龄相同，再根据工龄（降序）来排序，若工龄相同，根据薪水（降序）排序
        Set<Employee> set = new TreeSet<>();
        set.add(new Employee(27,2,2000.0));
        set.add(new Employee(30,3,3000.0));
        set.add(new Employee(30,8,9000.0));
        set.add(new Employee(30,8,15000.0));
        System.out.println(set);
        System.out.println("-----------------");


        //2.
        //Map
        //key:	value:
        //tom	    CoreJava
        //John	Oracle
        //Susan	Oracle
        //Jerry	JDBC
        //Jim	    Unix
        //Kevin	JSP
        //Lucy	JSP
        //
        //1） 使用一个Map，以老师的名字作为键，以老师教授的课程名作为值，表示上述 课程安排。
        //2） 增加了一位新老师Allen 教JDBC
        //3） Lucy 改为教CoreJava
        //4） 遍历Map，输出所有的老师及老师教授的课程(Set<Map.Entry<String,String>>、Set<String> get(key))
        //5） 利用Map，输出所有教JSP 的老师
        Map<String,String> map = new HashMap<>();
        map.put("tom","CoreJava");
        map.put("John","Oracle");
        map.put("Susan","Oracle");
        map.put("Jerry","JDBC");
        map.put("Jim","Unix");
        map.put("Kevin","JSP");
        map.put("Lucy","JSP");
        System.out.println(map);

        map.put("Allen","JDBC");
        System.out.println("增加一位新老师："+map);

        map.replace("Lucy","JDBC"); //替换 hashMap 中是指定的 key 对应的 value。
        System.out.println("Lucy改为教CoreJava："+map);

        //输出所有老师任课科目
        // 方式一：通过keySet()方法，将所有的key放入Set集合，
        Set<String> set2 = map.keySet();
        for (String teacher : set2) {//循环，根据Key遍历value
            System.out.println(teacher + "教："+map.get(teacher));//根据Key获取value值
        }

        //方式二：通过entrySet()方法，将键值对作为对象放入Set集合，然后循环Set取出对象里面的键值对
//        Set<Map.Entry<String,String>> set22 = map.entrySet();
//        for (Map.Entry<String, String> s : set22) {
//            System.out.println(s.getKey() + "教："+s.getValue());
//        }

        System.out.println("所有任课老师：");
        for (String teacher : set2)
            System.out.println(teacher);

        System.out.println("-----------------");
        //3. 集合中存储学生对象,属性有,学号,姓名,分数,请选择合适的集合进行存储,要求:
        //  (1). 先按分数的降序排列,如果分数相同,则按学号升序排列(给定多个分数相同的学生)
        //  (2). 求出学员的优秀人数,及优秀率; (达到80分及以上, 则为优秀)
        //  (3). 求出学员的及格人数,及及格率;(达到60分及以上, 则为及格)
        TreeSet<Student> set3 = new TreeSet<>();
        set3.add(new Student(1,"小明同学",75.2));
        set3.add(new Student(2,"小黑同学",65.0));
        set3.add(new Student(3,"小黄同学",65.0));
        set3.add(new Student(4,"小绿同学",90.2));
        System.out.println(set3);
        int Good = 0,Bad = 0;
        double sum=set3.size();
        for (Student stu : set3) {
            if (stu.score >= 80)
                Good++;
            else if (stu.score >= 60)
                Bad++;
        }
        System.out.println("优秀人数："+Good+"，优秀率："+(Good/sum));
        System.out.println("及格人数："+Bad+"，及格率："+(Bad/sum));

        //4. 辽宁省、吉林省、黑龙江省、广东省
        //辽宁省、
        //沈阳、大连、鞍山、抚顺、本溪、丹东、锦州、营口,阜新
        //吉林省
        //吉林市、四平市、通化市、白山市、辽源市、白城市
        //黑龙江省
        //哈尔滨市,齐齐哈尔市,鸡西市,鹤岗市,双鸭山市,大庆市
        //广东省
        //广州，深圳，珠海，东莞，佛山，中山，惠州
        //
        //要求使用键盘输入省的名称,得到所有的市 get方法
        String[] city = null;
        Map<String,String> map4 = new HashMap<>();
        System.out.println("请输入省份：辽宁省、吉林省、黑龙江省、广东省");
        Scanner sc = new Scanner(System.in);
        String province = sc.next();
        switch (province){
            case "辽宁省":
                map4.put("辽宁省","沈阳、大连、鞍山、抚顺、本溪、丹东、锦州、营口,阜新");break;
            case "吉林省":
                map4.put("吉林省","吉林市、四平市、通化市、白山市、辽源市、白城市");break;
            case "黑龙江省":
                map4.put("黑龙江省","哈尔滨市,齐齐哈尔市,鸡西市,鹤岗市,双鸭山市,大庆市");break;
            case "广东省":
                map4.put("广东省","广州，深圳，珠海，东莞，佛山，中山，惠州");break;
        }
        Set<String> set4 = map4.keySet();
        for (String c : set4) {
            System.out.println(map4.get(c));
        }
    }
}

class Student implements Comparable<Student>{
    int ID;
    String name;
    Double score;

    public Student(int ID, String name, Double score) {
        this.ID = ID;
        this.name = name;
        this.score = score;
    }

    //  (1). 先按分数的降序排列,如果分数相同,则按学号升序排列(给定多个分数相同的学生)
    //  (2). 求出学员的优秀人数,及优秀率; (达到80分及以上, 则为优秀)
    //  (3). 求出学员的及格人数,及及格率;(达到60分及以上, 则为及格)
    @Override
    public int compareTo(Student o) {
        if (this.score.equals(o.score))
            return this.ID-o.ID;
        return o.score.compareTo(this.score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

}
class Employee implements Comparable<Employee>{
    int age;
    int workYear;
    Double salary;

    public Employee(int age, int workYear, Double salary) {
        this.age = age;
        this.workYear = workYear;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", workYear=" + workYear +
                ", salary=" + salary +
                '}';
    }

    //向TreeSet集合中加入5个员工的对象，根据员工的年龄（升序）进行排序，若年龄相同，再根据工龄（降序）来排序，若工龄相同，根据薪水（降序）排序
    @Override
    public int compareTo(Employee o) {
        if (this.age == o.age){
             if (this.workYear == o.workYear)
                return o.salary.compareTo(this.salary);
            return o.workYear - this.workYear;
        }
        return this.age-o.age;
    }
}