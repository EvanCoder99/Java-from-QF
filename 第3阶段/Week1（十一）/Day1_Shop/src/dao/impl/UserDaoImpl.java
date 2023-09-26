package dao.impl;

import dao.UserDao;
import entity.User;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

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

    @Override
    public List<User> selectUser() throws SQLException {
        String sql = "select * from user";
        return runner.query(sql,new BeanListHandler<>(User.class));
    }

    @Override
    public int deleteUser(String uId) throws SQLException {
        String sql = "delete from user where u_id=?";
        return runner.update(sql,uId);
    }

    @Override
    public List<User> searchUsers(String uName, String uSex) throws SQLException {
        String value = "";
        boolean flag = false;

        if (!uName.equals("")) {
            value = "u_name like '%"+uName+"%'";
            flag = true;
        }
        if (!uSex.equals("")) {
            if (flag)
                value += "and u_sex = '"+uSex+"'";
            else
                value += "u_sex = '"+uSex+"'";
        }
        String sql = "select * from user where "+value;
        System.out.println("sql--->"+sql);
        return runner.query(sql,new BeanListHandler<>(User.class));
    }


}
