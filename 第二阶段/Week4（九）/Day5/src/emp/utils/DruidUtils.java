package emp.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtils {
    public static DataSource dataSource;//准备数据源
    private static Properties p = new Properties();
    static{
        try {
            //从资源目录src下，根据路径获取配置文件
            InputStream is = DbUtils.class.getResourceAsStream("/druid.properties");
//            p.load(new FileInputStream("Day5/src/druid.properties"));
            p.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = dataSource.getConnection();
//            con = DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /*public static void closeAll(AutoCloseable...a){
        for (AutoCloseable ac : a) {
            if (ac != null) {
                try {
                    ac.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
}
