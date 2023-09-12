package day1_Servlet.c_Test.c_Dao;

import day1_Servlet.c_Test.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    public int add(Person p) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtils.getConnection();
            String sql = "insert into person (name,age,bornDate,email) values (?,?,?,?)";

            ps = con.prepareStatement(sql);
            ps.setString(1,p.getName());
            ps.setInt(2,p.getAge());
            Date date = new Date(p.getBornDate().getTime());
            ps.setDate(3,date);//需要将java.util日期转java.sql
            ps.setString(4,p.getEmail());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(ps,con);
        }
        return 0;
    }

    public int update(Person p) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtils.getConnection();
            String sql = "update person set name=?,age=?,bornDate=?,email=? where id = ?";
            ps = con.prepareStatement(sql);

            ps.setString(1,p.getName());
            ps.setInt(2,p.getAge());
            Date date = new Date(p.getBornDate().getTime());
            ps.setDate(3,date);//需要将java.util日期转成java.sql
            ps.setString(4,p.getEmail());
            ps.setInt(5,p.getId());

            return ps.executeUpdate();
        } catch (Exception e) {
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
            String sql = "delete from person where id = ?";
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

    public List<Person> query() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Person> list = new ArrayList<>();

        try {
            con = DBUtils.getConnection();
            String sql = "select * from person";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                //因为属性bornDate是util.Date，而拿到的是sql.Date，子赋值给父，多态所以没问题
                Date bornDate = rs.getDate("bornDate");
                String email = rs.getString("email");

                Person person = new Person(id, name, age, bornDate, email);
                list.add(person);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs,ps,con);
        }
        return null;
    }
}
