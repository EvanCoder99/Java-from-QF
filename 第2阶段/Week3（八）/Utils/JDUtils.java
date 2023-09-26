package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDUtils {
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?serverTimezone=UTC", "root", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

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
