package week5.day4_Reflect.Bstation;

import jdk.nashorn.internal.objects.NativeUint8Array;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileReader {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("e:/a.txt");
            int len = 0;
            char[] c = new char[4];
            while ((len = fr.read(c)) != -1)
                System.out.println(new String(c,0,len));


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
