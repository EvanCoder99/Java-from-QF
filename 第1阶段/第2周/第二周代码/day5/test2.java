package week2.day5;

//直接引用多态，调用重载
//将狗当成动物看待，可调用动物的吃的方法，如果狗有不同吃的行为，则优先调用狗的行为
public class test2 {
    public static void main(String[] args) {
        Animal2 animal = new Dog2();
        animal.eat();
    }
}
class Animal2{
    public void eat(){
        System.out.println("动物正在吃东西");
    }
}
class Dog2 extends Animal2{
    @Override
    public void eat() {
        System.out.println("狗在吃屎");
    }
}