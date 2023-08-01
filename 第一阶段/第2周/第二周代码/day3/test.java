package week2.day3;

class Rise {
    String name = "五常大米";
}

class Yao {
    String name = "999感冒灵";
}

class Student {

    public void eat(Rise rise, Yao... yao) {
        System.out.println("小明在吃饭：" + rise.name);
        System.out.println("小明在吃药：" + yao[0]);
    }

}

public class test {
    public static void main(String[] args) {
        Student st = new Student();
        st.eat(new Rise(), new Yao());
    }
}