package week5.day5.weekTest;

import java.util.Arrays;
import java.util.Random;

public class test2 {
    public static void main(String[] args) {
        int sum = 0;
        System.out.println("1、-------------");
        int[] a1 = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            a1[i] = random.nextInt(21);
            sum+=a1[i];
            System.out.print(a1[i] + " ");
        }

        System.out.println("\n2、-------------");
        System.out.println("总和为："+sum);
        System.out.println("平均数为："+(sum/a1.length));
        Arrays.sort(a1);

        System.out.println("3、-------------");
        String s = Arrays.toString(a1);
        System.out.println("排序后："+s);

        System.out.println("4、-------------");
        int[] count = new int[20];
        char[] c = s.toCharArray();
        for (int i = 48; i < 58; i++){
            int cs = 0;
            for (int j = 0; j < c.length; j++) {
                if (i == c[j])
                    cs++;
            }
            count[i-48] = cs;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println(i+"出现的次数："+count[i]);
        }

    }
}
