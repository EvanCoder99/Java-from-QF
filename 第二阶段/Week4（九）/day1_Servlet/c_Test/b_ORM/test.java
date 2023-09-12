package day1_Servlet.c_Test.b_ORM;

import day1_Servlet.c_Test.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<entity> list = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            String sql = "select * from admin";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String love = rs.getString("love");

                entity entity = new entity(id, username, password, sex, love);
                list.add(entity);
            }
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs,ps,con);
        }
    }
}
