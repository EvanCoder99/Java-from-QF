package day4_DAO.d_dao;

import Utils.JDUtilsProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PerosnDaoImpl {
    public int add(Person p) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = JDUtilsProperties.getConnection();
            String sql = "insert into person(name,age,bornDate,email) values(?,?,?,?)";
            ps = con.prepareStatement(sql);

            ps.setString(1,p.getName());
            ps.setInt(2,p.getAge());
            //报错：提供的类型util.date（父），需要的类型是sql.date（子）
            // util.date是sql.date的父类，而bornDate是util的date，大转小，也可以强转(Date)
            Date date = new Date(p.getBornDate().getTime()); //转成sql.date
            ps.setDate(3,date);
            ps.setString(4, p.getEmail());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDUtilsProperties.closeAll(ps,con);
        }
        return 0;
    }

    public int update(Person p) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDUtilsProperties.getConnection();
            String sql = "update person set name=?,age=?,bornDate=?,email=? where id=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,p.getName());
            ps.setInt(2,p.getAge());
            Date date = new Date(p.getBornDate().getTime());
            ps.setDate(3,date);
            ps.setString(4,p.getEmail());
            ps.setInt(5,p.getId());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDUtilsProperties.closeAll(ps,con);
        }

        return 0;
    }

    public int deleteByID(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDUtilsProperties.getConnection();
            String sql = "delete from person where id=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDUtilsProperties.closeAll(ps,con);
        }
        return 0;
    }

    public List<Person> queryAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Person> list = new ArrayList<>();
        try {
            con = JDUtilsProperties.getConnection();
            String sql = "select * from person";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                //拿到java.sql的Date类型，但可直接赋值给java.util
                Date bornDate = rs.getDate("bornDate");
                String email = rs.getString("email");

                Person p = new Person(id, name, age, bornDate, email);
                list.add(p);
                return list;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDUtilsProperties.closeAll(rs,ps,con);
        }
        return null;
    }
}
