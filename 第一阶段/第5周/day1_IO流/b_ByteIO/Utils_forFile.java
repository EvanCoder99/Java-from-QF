package week5.day1_IOStream.b_ByteIO;

import java.io.Closeable;
import java.io.IOException;

public class Utils_forFile {
    public static void closeAll(Closeable... c){
        for (Closeable cs : c){
            if (cs != null){
                try {
                    cs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
