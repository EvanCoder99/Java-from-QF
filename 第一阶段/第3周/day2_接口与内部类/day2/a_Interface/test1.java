package week3.day2.a_Interface;

interface USB{
    int DISK = 1;
    int MOUSE = 2;
    void use();
}
class Mouse implements USB{
    @Override
    public void use() {
        System.out.println("usb标准的鼠标正在使用");
    }
}
class Disk implements USB{
    @Override
    public void use() {
        System.out.println("usb标准的硬盘正在使用");
    }
}
class Person{
    public USB buy(int i){
        if (i == USB.DISK){
            return new Mouse();
        }else if (i == USB.MOUSE){
            return new Mouse();
        }else
            return null;
    }
}
public class test1 {
    public static void main(String[] args) {
        Person p = new Person();
        USB usb = p.buy(USB.MOUSE);
        if (usb != null)
            usb.use();
    }
}
