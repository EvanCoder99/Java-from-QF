package day7.yuanawen;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static final ThreadLocal<Connection> TH = new ThreadLocal<>();
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

    //开启事务
    public static void begin() {
        Connection con = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //提交事务
    public static void commit() {
        Connection con = null;
        try {
            con = getConnection();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            TH.remove();
            System.out.println("submit移除连接对象");
            closeAll(con);
        }
    }

    public static void rollback(){
        Connection con = null;
        try {
            con = getConnection();
            con.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            TH.remove();
            System.out.println("rollback移除连接对象");
            closeAll(con);
        }
    }
}
