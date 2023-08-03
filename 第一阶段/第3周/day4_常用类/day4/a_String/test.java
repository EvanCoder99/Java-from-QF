package week3.day4.a_String;

public class test {
    public static void main(String[] args) {
        //因为字符串存放在常量池，常量池相同资源只会保留一份，a,b两个引用共同指向了zz
        String a = "zz";
        String b = "zz";
        System.out.println(a == b); //true

        String aa = new String("zs");
        String bb = new String("zs");
        System.out.println(aa == bb);  //false

        System.out.println(a == aa);    //false，堆区地址 VS 常量池地址

    }
}
