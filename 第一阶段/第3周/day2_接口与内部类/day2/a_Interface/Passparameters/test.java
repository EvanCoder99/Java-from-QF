package week3.day2.a_Interface.Passparameters;

public class test {
    public static void main(String[] args) {
        Person p = new Person();
        //1、抽象类完成多态
        p.open(new SafeDoor()); //人开安全门
        p.open(new SuperDoor());    //人开超级门

        //2、接口完成多态
        p.zhiwenCheck(new SafeDoor());  //Izhiwen i = new SafeDoor()
        p.faceCheck(new SuperDoor());
    }
}
abstract class Door{
    public abstract void info();
}
interface Izhiwen{
    void zhiwenJC();
}
interface Ifance{
    void faceJC();
}

class SafeDoor extends Door implements Izhiwen{
    @Override
    public void zhiwenJC() {
        System.out.println("指纹检测安全门成功");
    }

    @Override
    public void info() {
        System.out.println("安全门打开了~");
    }
}
class SuperDoor extends Door implements Izhiwen,Ifance{
    @Override
    public void zhiwenJC() {
        System.out.println("指纹检测超级门成功");
    }

    @Override
    public void faceJC() {
        System.out.println("人脸识别检测超级门成功");
    }

    @Override
    public void info() {
        System.out.println("超级防盗门打开了~");
    }
}
class Person{
    public void open(Door door){
        door.info();
    }

    public void zhiwenCheck(Izhiwen i){
        i.zhiwenJC();
    }
    public void faceCheck(Ifance i){
        i.faceJC();
    }

}