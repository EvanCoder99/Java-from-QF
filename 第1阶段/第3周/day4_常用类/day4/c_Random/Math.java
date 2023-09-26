package week3.day4.c_Random;

public class Math {
    public static void main(String[] args) {
        //Math类：可以生成随机数，也可以数学操作
        //[0.0-1.0)
        System.out.println(java.lang.Math.random());

        //求1-100
        int a=  (int)(java.lang.Math.random()*1000)+1;
        System.out.println(a);

        //封装
        System.out.println(getRandon(3,5));
    }

    private static int getRandon(int start, int end) {
        //[start.0，end.0)
        return (int)(java.lang.Math.random()*(end-start+1)+start);
    }
}
