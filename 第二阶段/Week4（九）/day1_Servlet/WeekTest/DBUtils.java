package day1_Servlet.WeekTest;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    public static DataSource dataSource;
    private static Properties p = new Properties();

    static {
        try {
            p.load(new FileInputStream("Week9/db.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(p);
//            Class.forName(p.getProperty("driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeAll(AutoCloseable...ac) {
        for (AutoCloseable a : ac) {
            if (a != null) {
                try {
                    a.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
