package week4.day3_Exception;

import com.sun.javafx.image.BytePixelSetter;
import sun.nio.cs.ext.MS874;

import java.util.HashMap;
import java.util.Scanner;

public class YuanAWen {
    public static void main(String[] args) {
        //1.输入两个数字实现两个数字相除,异常处理try...catch
        // 提示：例如输入字符串，例如初始为0
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入2个数字：");
        try {
            double a = sc.nextInt();
            int b = sc.nextInt();
            try {
                System.out.println("两数相除="+(a/b));
            } catch (Exception e) {
                System.out.println("被除数不能为0！");
            }
        } catch (Exception e) {
            System.out.println("请输入整数！");
        }

        //2、输入两个数字实现两个数字相除,异常处理try...catch...finally
        fun();

        //3、自定义异常 /年龄异常/性别异常
        Stu s1 = new Stu();
        try {
            s1.setName("平哥最爱小凤姐");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            s1.setAge(999);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //4. 输入1～3之间任一个数字，程序将输出相应的课程名称  如:Map<Integer,String> maps =......  maps.put(1,"java")输入正确，输出对应课程名称。 如果输入错误，给出错误提示,不管输入是否正确，均输出“欢迎提出建议”语句
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"Java");
        map.put(2,"JSP");
        map.put(3,"MySQL");
        System.out.println("输入1～3之间任一个数字：");
        int num = 0;
        try {
            num = sc.nextInt();
            if (num<1 || num>3)
                System.out.println("请输入1～3之间的数字！");
            else
                System.out.println("对应的课程是："+map.get(num));
        } catch (Exception e) {
            System.out.println("请输入整数！");
        }finally {
            System.out.println("欢迎提出建议");
        }


        //5、今天线程基础案例，是否有数据安全性的问题？为什么?
        /*
        *   没有数据安全问题，因为没有涉及到共享数据的操作，使用的都是局部变量
        * */

        //6、使用匿名内部类方式创建及启动线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 150; i++)
                    System.out.println("子线程："+i);
            }
        }).start();
        for (int i = 0; i < 150; i++) {
            System.out.println("主线程："+i);
        }

        //7.为什么模拟List集合的线程安全的锁对象用this能确保同一个锁对象？请说明理由
        /*
        *   synchronized作用于方法时，锁住的是对象的实例(this)，只要是当前类的任何实例对象，都可以完成锁的效果，所以线程1执行该方法的时候，线程2就必须等待
        * */


    }
    public static void fun(){
        System.out.println("请输入2个数字：");
        Scanner sc = new Scanner(System.in);
        try {
            double a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("两数相除="+(a/b));
            System.exit(0);
        } catch (Exception e) {
            System.out.println("输入有误！");
        } finally {
            fun();
        }
    }
}


class myException extends RuntimeException{ //自定义异常 /年龄异常/性别异常
    public myException(String message){
        super(message);
    }
}
class Stu{
    private String name;
    private int age;

    public void setName(String name) {
        if (name.length() > 6)
            throw new myException("姓名长度需要小于6");
        else
            this.name = name;
    }

    public void setAge(int age) {
        if (age<0 || age > 120)
            throw new myException("年龄需要大于0且小于120");
        else
            this.age = age;
    }
}