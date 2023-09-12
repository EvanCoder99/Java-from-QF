package day1_Servlet.WeekTest;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class userDaoImpl {
    private QueryRunner runner = new QueryRunner(DBUtils.dataSource);

    public int add(User u) throws SQLException {
        String sql = "insert into tb_user (name,password) values(?,?)";
        return DaoUtils.update(sql,u.getName(),u.getPassword());
    }


    public int update(User u) throws SQLException {
        String sql = "update tb_user set name=?,password=?";
        return runner.update(sql,u.getName(),u.getPassword());
    }

    public int delete(String name) throws SQLException { //根据用户名删除
        String sql = "delete from tb_user where name = ?";
        return runner.update(sql,name);
    }

    public int delete(int id) throws SQLException {
        String sql = "delete from tb_user where id = ?";
        return runner.update(sql,id);
    }

    public List<User> queryAll() throws SQLException {
        String sql = "select * from tb_user";
        return runner.query(sql,new BeanListHandler<>(User.class));
    }

    public User queryByID(int id) throws SQLException {
        String sql = "select * from tb_user where id = ?";
        return runner.query(sql,new BeanHandler<>(User.class),id);
    }
}
