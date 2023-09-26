package day3_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class a_DML {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            //1、加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2、获取连接对象
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?serverTimezone=UTC", "root", "1234");

            //3、创建执行对象
            st = con.createStatement();

            String sql = "insert into t_jobs values('TEST','IT',10000,20000)";

            //4、执行SQL语句
            int result = st.executeUpdate(sql);

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDUtils.closeAll(st,con);
        }
    }
}
