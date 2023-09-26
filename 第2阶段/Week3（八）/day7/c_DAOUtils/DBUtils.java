package day7.c_DAOUtils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static Properties p = new Properties();
    static{
        try {
            p.load(new FileInputStream("Week8/db.properties"));
            Class.forName(p.getProperty("driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
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
