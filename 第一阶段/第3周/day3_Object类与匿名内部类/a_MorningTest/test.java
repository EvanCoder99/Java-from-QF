package week3.day3.a_MorningTest;

public class test {
    public static void main(String[] args) {
        Person p = new Person();
        p.useDoor(new safeDoor());
        p.useDoor(new SuperDoor());
    }
}
interface Door{
    void open();
}
class safeDoor implements Door{
    @Override
    public void open() {
        System.out.println("安全门开门");
    }
}
class SuperDoor implements Door{
    @Override
    public void open() {
        System.out.println("超级闷打开了");
    }
}
class Person{
    public void useDoor(Door door) {
        door.open();
    }
}