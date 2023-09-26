package day1_Servlet.c_Test.a_JDBC;

import java.sql.*;

public class a_prepareStatement {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?serverTimezone=UTC","root","1234");

            String sql = "update admin set username = 180 where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,3);

            System.out.println(ps.executeUpdate());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null || ps != null) {
                try {
                    ps.close();
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
