package week3.day3.b_ObjectClass.UnNameInnerClass;

public class canshuDuoTai {
    public static void main(String[] args) {
        //1.直接引用多态，多态调用重写方法
        USB usb = new Disk();
        usb.run();

        //2.多态传参：将测试类看成第三方类
        canshuDuoTai.connect(new Disk());

        //3.匿名内部类
        canshuDuoTai.connect(new Disk(){
            @Override
            public void run() {
                System.out.println("匿名设备正在运作");
            }
        });

        canshuDuoTai.connect(new USB(){
            @Override public void run() {System.out.println("匿名设备正在运作");}
        }
        );

    }
    public static void connect(USB usb){
        usb.run();//接口回调
    }
}
interface USB{
    void run();
}
class Disk implements USB{
    @Override
    public void run() {
        System.out.println("硬盘正在运转");
    }
}