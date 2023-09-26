package day3_JDBC;

public class JDUtils {
    public static void closeAll(AutoCloseable...ac){
        for (AutoCloseable acs : ac) {
            if (acs!=null){
                try {
                    acs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
