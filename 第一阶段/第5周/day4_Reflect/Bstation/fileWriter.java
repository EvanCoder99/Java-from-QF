package week5.day4_Reflect.Bstation;

import java.io.FileWriter;
import java.io.IOException;

public class fileWriter {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
//            fw = new FileWriter("e:/a.txt",true);
            fw = new FileWriter("e:/a.txt");
            char[] c = {'我','是','中','国','人'};
            fw.write(c);

            fw.write(c,2,3);
            fw.write("\n");
            fw.write("我是一名java工程师");

            fw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
