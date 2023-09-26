package day1_Servlet.c_Test.a_JDBC;

import day1_Servlet.c_Test.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class a_jdbcFZ {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            String sql = "update admin set username = 102 where id = 3";
            ps = con.prepareStatement(sql);
            System.out.println(ps.executeUpdate());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll();
        }
    }
}
