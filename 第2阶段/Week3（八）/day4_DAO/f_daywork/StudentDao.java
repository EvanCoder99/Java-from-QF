package day4_DAO.f_daywork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public int add(Student stu) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            String sql = "insert into student (name,age) values(?,?)";
            ps = con.prepareStatement(sql);

            ps.setString(1,stu.getName());
            ps.setInt(2,stu.getAge());

            return ps.executeUpdate();   //填充数据

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(ps,con);
        }
        return 0;
    }

    public int update(Student stu) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            String sql = "update student set name=?,age=? where id=?";
            ps = con.prepareStatement(sql);

            ps.setString(1,stu.getName());
            ps.setInt(2,stu.getAge());
            ps.setInt(3,stu.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(ps,con);
        }

        return 0;
    }

    public int deleteById(int id) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtils.getConnection();
            String sql = "delete from student where id = ?";
            ps = con.prepareStatement(sql);

            ps.setInt(1,id);

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(ps,con);
        }
        return 0;
    }

    public List<Student> queryAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Student> list = new ArrayList<>();

        try {
            con = DBUtils.getConnection();
            String sql = "select * from student";
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                Student stu = new Student(id, name, age);

                list.add(stu);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs,ps,con);
        }
        return list;
    }
}
