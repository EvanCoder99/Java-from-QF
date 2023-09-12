package day7.d_Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtils {
    private static DataSource dataSource;   //准备数据源
    private static Properties p = new Properties();

    static{
        try {
            p.load(new FileInputStream("Week8/druid.properties"));
            //传入properties资源，得到druid的数据源
            dataSource = DruidDataSourceFactory.createDataSource(p);

//            p.load(new FileInputStream("Week8/db.properties"));
//            Class.forName(p.getProperty("driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            //从数据源中取出连接对象
            con = dataSource.getConnection();
//            con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeAll(AutoCloseable...ac){
        for (AutoCloseable acs : ac) {
            if (acs!=null){
                try {
                    acs.close();    //在连接池中，连接对象的关闭，其实是回收
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
