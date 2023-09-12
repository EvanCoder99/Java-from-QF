package day1_Servlet.c_Test.a_JDBC;

import java.sql.*;

public class a_jdbc {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            //1、加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2、获取连接对象
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?serverTimezone=UTC","root","1234");

            //3、创建执行对象
            st = con.createStatement();

            //4、执行SQL
//            String sql = "update admin set username = 666 where id = 3";
            String sql = "select * from admin";

            //5、返回SQL结果，查询返回结果集，DML返回印象条数
//            int i = st.executeUpdate(sql);
//            System.out.println(i);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String love = rs.getString("love");

                System.out.println(username+"\t"+password+"\t"+sex+"\t"+love);
            }

            //6、关闭连接资源
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null || st != null){
                try {
                    st.close();
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
