package dao.impl;

import dao.UserDao;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.C3P0Utils;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

    //业务层捕获，配合事务
    @Override
    public User selectByName(String name) throws SQLException {
        String sql = "select * from user where u_name = ?";
        return runner.query(sql,new BeanHandler<>(User.class),name);
    }

    @Override
    public int addUser(User u) throws SQLException {
        String sql = "insert into user(u_name,u_password,u_email,u_sex,u_status,u_code,u_role) values(?,?,?,?,?,?,?)";
        return runner.update(sql,u.getU_name(),u.getU_password(),u.getU_email(),u.getU_sex(),u.getU_status(),u.getU_code(),u.getU_role());
    }

    @Override
    public User selectByCode(String code) throws SQLException {
        String sql = "select * from user where u_code=?";
        return runner.query(sql,new BeanHandler<User>(User.class),code);
    }

    @Override
    public int updateStatus(int id) throws SQLException {
        String sql = "update user set u_status=1 where u_id=?";
        return runner.update(sql,id);
    }

//    public static void main(String[] args) throws SQLException {
//        User user = new User(0, "zs", "123", "xxx", "1", 1, "dd", 1);
//        System.out.println(new UserDaoImpl().addUser(user));
//
//        System.out.println(new UserDaoImpl().selectByName("zs"));
//    }
}
