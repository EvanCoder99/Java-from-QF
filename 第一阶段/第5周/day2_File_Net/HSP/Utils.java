package week5.day2_File_Net.HSP;

import java.io.Closeable;
import java.io.IOException;

public class Utils {
    //所有流都实现了Closeable接口
    public static void closeAll(Closeable...c){
        if (c != null){
            for (Closeable ca : c) {
                try {
                    ca.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
