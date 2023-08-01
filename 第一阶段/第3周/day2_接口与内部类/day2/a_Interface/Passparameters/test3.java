package week3.day2.a_Interface.Passparameters;

//案例：电脑连接USB标准的设备：鼠标、键盘、硬盘
//电脑类（第三方）、鼠标类、键盘类、USB接口
//方法：连接、运转
interface USB{
    public abstract void run();
}
class Mouse implements USB{
    @Override
    public void run() {
        System.out.println("鼠标正在运行");
    }
}
class Disk implements USB{
    @Override
    public void run() {
        System.out.println("硬盘正在运转");
    }
}
class Computer{
    public void connect(USB usb){
        usb.run();
    }
}
public class test3 {
    public static void main(String[] args) {
        Computer com = new Computer();
        com.connect(new Mouse());
        com.connect(new Disk());

    }
}
