package day7.a_YouHua_account;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    //共享ThreadLocal，里面管理连接对象Connection，类似集合
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
//            con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));

            con = TH.get(); //从ThreadLocal中获取连接对象
            if (con == null) {
                con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
                TH.set(con);    //连接对象存储到ThreadLocal中
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
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


    public static void closeAll(AutoCloseable...ac){
        for (AutoCloseable acs : ac) {
            /*if (acs instanceof Connection) {
                TH.remove();
                System.out.println("移除连接对象");
            }*/

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
