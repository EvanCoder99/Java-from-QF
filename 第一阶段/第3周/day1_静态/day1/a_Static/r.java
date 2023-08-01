package week3.day1.a_Static;

class Girl {
    static String name;

    public void wash() {
        System.out.println("女朋友" + name + "正在帮忙洗衣服");
    }
}

public class r {
    public static void main(String[] args) {
        Girl lyf = new Girl();

        Girl.name = "刘亦菲";  //lyf.name = "刘亦菲";

        Girl fj = new Girl();
        Girl.name = "凤姐";  //fj.name = "风姐";
        lyf.wash();//刘亦菲
        fj.wash();//凤姐
    }
}
