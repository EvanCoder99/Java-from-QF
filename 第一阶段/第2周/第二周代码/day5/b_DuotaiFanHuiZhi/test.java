package week2.day5.b_DuotaiFanHuiZhi;

//返回值多态：调用方法返回子类对象，由父类引用接收；构成返回值多态
//案例：主人购买宠物；根据标识购买不同宠物；1.买鸟 2.买狗
//分析：主人类（三方类）、宠物类、鸟类、狗类，方法：购买
public class test {
    public static void main(String[] args) {
        Master master = new Master();
        Pet pet = master.bug(1);
        pet.eat();
    }
}

class Pet {
    public void eat(){
        System.out.println("宠物吃东西");
    }
}

class Bird extends Pet {
    @Override
    public void eat() {
        System.out.println("鸟吃东西");
    }
}

class Dog extends Pet {
    @Override
    public void eat() {
        System.out.println("狗吃东西");
    }
}

class Master {
    public Pet bug(int type) {
        if (type == 1) {
            return new Bird();
        } else if (type == 2) {
            return new Dog();
        } else
            return null;
    }
}