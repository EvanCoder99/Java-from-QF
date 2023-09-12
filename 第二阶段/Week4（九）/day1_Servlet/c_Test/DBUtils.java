package day1_Servlet.c_Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static Properties p = new Properties();
    static{
        try {
            p.load(new FileInputStream("Week9/day1_Servlet/c_Test/a_JDBC/test.properties"));
            Class.forName(p.getProperty("driver"));
//            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?serverTimezone=UTC","root","1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeAll(AutoCloseable...a){
        for (AutoCloseable ac : a) {
            if (ac != null) {
                try {
                    ac.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
