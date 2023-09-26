package week5.day5.c_localTime;

import java.time.LocalDate;

import static week5.day5.c_localTime.Test.changeString;

class Test {
    public static void changeString(StringBuffer sb) {
        sb = new StringBuffer();
        sb.append("stringbuffer2");
    }
}

    public class localDate {
        public static void main(String[] args) {
            int[] numbers=new int[]{2,1,3};
            StringBuffer sb = new StringBuffer("stringbuffer1");
            changeString(sb);
            System.out.println("sb = " + sb.toString());


        }
    }
