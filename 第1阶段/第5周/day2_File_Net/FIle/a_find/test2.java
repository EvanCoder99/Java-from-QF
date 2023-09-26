package week5.day2_File_Net.FIle.a_find;

import java.io.File;

public class test2 {
    public static void main(String[] args) {
        File f = new File("e:");
        File[] files = f.listFiles();
        for (File ff : files) {
            System.out.println(ff.getAbsolutePath());
            System.out.println(ff.getName());
        }
    }
}
