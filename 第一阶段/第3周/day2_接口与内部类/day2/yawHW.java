package week3.day2;

public class yawHW {
    public static void main(String[] args) {
        //1、自定义接口Play，及实现类Dog 实现接口方法play,狗类重写play进行抓飞碟方法，进行测试
        System.out.println("1、================");
        Dog dog = new Dog();
        dog.play();


        //2、实现防盗门：创建抽象类Door、接口Lock 定义上锁方法、接口Bell定义门铃方法，创建类AntiThiefDoor,继承及实现接口
        System.out.println("2、================");
        AntiThiefDoor atf = new AntiThiefDoor();
        atf.info();
        atf.ring();
        atf.upLock();

        //3、创建打印机类Printer，打印机使用墨盒打印
        //接口InkBox墨盒方法为获取颜色，
        //Colorink和Blackink两个实现类实现彩色和黑白墨盒，
        //创建测试类测试接口回调(接口传参多态)
        System.out.println("3、================");
        Printer p = new Printer();
        p.use(new Colorink());
        p.use(new Blackink());


        //4、内部类的特点；以及有哪些内部类？
        //答：
        //1、一个类的内部又嵌套了另外一个类，嵌套的类成为内部类，被嵌套的类成为外部类
        //2、外部内的资源可以直接在内部类中使用，而不破坏封装性，并且体现类与类之间的包含关系
        //3、内部类会产生独立的class文件


        //5、请在以下代码的基础上完成下面几个小题
        //（1）在①和②的位置标注出内部类和外部类
        //（2）在③的位置定义一个count变量用来存放Circle实例的个数，并在④的位置编写语句用来统计Circle实例的个数。
        //（3）在⑤和⑥处根据注释语句填写代码
        //（4）在main()⑦的位置上编写语句调用Draw类中的drawSahpe()。 ：
        // class Circle {  //①   ________外部类_________
        //	private double radius = 0;
        //	③  ____static_int count  = 0;____________
        //	 public Circle(double radius) {
        //		 this.radius = radius;
        //		  ④  ____count++;_____________
        //	  }
        //    	class Draw {   //②  ________内部类_________
        //		  public void drawSahpe() {
        //           		 ⑤ _____System.out.println(radius);____________  //输出radius变量的值
        //	                 ⑥ _____System.out.println(count++);____________ //输出count变量的值
        //		 }
        //	}
        //}
        //public class OuterInnerClass {
        //	public static void main(String[] args) {
        //		⑦ _______new Circle().new Draw().drawSahpe() __________ //编写语句调用Draw类中的drawSahpe()
        //
        //	}
        //}


    }
}
interface InkBox{
    void getColor();
}
class Colorink implements InkBox{
    @Override
    public void getColor() {
        System.out.println("获取彩色墨盒~~~");
    }
}
class Blackink implements InkBox{
    @Override
    public void getColor() {
        System.out.println("获取黑色墨盒~~~");
    }
}
class Printer{
    public void use(InkBox ink){
        ink.getColor(); //接口回调
    }
}

interface Bell{
    void ring();
}
interface Lock{
    void upLock();
}
abstract class Door{
    public abstract void info();
}
class AntiThiefDoor extends Door implements Lock,Bell{
    @Override
    public void info() {
        System.out.println("这是一扇防盗门~");
    }

    @Override
    public void ring() {
        System.out.println("防盗门铃正在叮叮叮！！！");
    }

    @Override
    public void upLock() {
        System.out.println("防盗门正在上锁......");
    }
}

interface Play{
    void play();
}
class Dog implements Play{
    @Override
    public void play() {
        System.out.println("小狗正在抓飞碟~~~");
    }
}