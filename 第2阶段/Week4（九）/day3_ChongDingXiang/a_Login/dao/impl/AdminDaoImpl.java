package day3_ChongDingXiang.a_Login.dao.impl;

import day3_ChongDingXiang.a_Login.dao.AdminDao;
import day3_ChongDingXiang.a_Login.entity.Admin;
import day3_ChongDingXiang.a_Login.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private QueryRunner runner = new QueryRunner();
    @Override
    public Admin queryByName(String name) throws SQLException {
        String sql = "select * from admin where username = ?";
        return runner.query(DBUtils.getConnection(),sql,new BeanHandler<>(Admin.class),name);
    }

    @Override
    public List<Admin> queryAdmins() throws SQLException {
        String sql = "select * from admin";
        return runner.query(DBUtils.getConnection(),sql,new BeanListHandler<>(Admin.class));
    }

//    public static void main(String[] args) throws SQLException {
//        System.out.println(new AdminDaoImpl().addAdmin(new Admin("老李头","123","123","北京")));
//    }

    @Override
    public int addAdmin(Admin a) throws SQLException {
        String sql = "insert into admin (username,phone,password,address) values(?,?,?,?)";
        return runner.update(DBUtils.getConnection(),sql,a.getUsername(),a.getPhone(),a.getPassword(),a.getAddress());
    }

    @Override
    public int updateAdmin(Admin admin) {
        return 0;
    }

    @Override
    public int deleteByName(String name) {
        return 0;
    }
}
