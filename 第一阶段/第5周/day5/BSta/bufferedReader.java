package week5.day5.BSta;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class bufferedReader {
    public static void main(String[] args) throws Exception {
        FileReader fis = new FileReader("e:/a.txt");
        BufferedReader br = new BufferedReader(fis);

        //读一行，readLine()读到末尾返回null
        String s = br.readLine();

        while (( s = br.readLine()) != null)
            System.out.println(s);

    }
}
