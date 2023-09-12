package day1_Servlet.a_daoutils;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class PerosnDaoImpl {
    //QueryRunner()中传入数据源后，无需每个功能都加入连接对象
    private QueryRunner runner = new QueryRunner(DruidUtils.dataSource);
    public int add(Person p) throws SQLException {
        String sql = "insert into person(name,age,bornDate,email) values(?,?,?,?)";
        return runner.update(sql,p.getName(),p.getAge(),p.getBornDate(),p.getEmail());
//        return runner.update(DBUtils.getConnection(),sql,p.getName(),p.getAge(),p.getBornDate(),p.getEmail());
//        return DaoUtils.commonUpdate(sql,p.getName(),p.getAge(),p.getBornDate(),p.getEmail());
    }

    public int update(Person p) throws SQLException {
        String sql = "update person set name=?,age=?,bornDate=?,email=? where id=?";
        return runner.update(sql,p.getName(),p.getAge(),p.getBornDate(),p.getEmail());
//        return runner.update(DBUtils.getConnection(),sql,p.getName(),p.getAge(),p.getBornDate(),p.getEmail());
//        return DaoUtils.commonUpdate(sql,p.getName(),p.getAge(),p.getBornDate(),p.getEmail(),p.getId());
    }

    public int deleteByID(int id) throws SQLException {
        String sql = "delete from person where id=?";
        return runner.update(sql,id);
//        return runner.update(DBUtils.getConnection(),sql,id);
//        return DaoUtils.commonUpdate(sql,id);

    }

    public List<Person> queryAll() throws SQLException {
        String sql = "select * from person";
        return runner.query(sql,new BeanListHandler<>(Person.class));
//        return DaoUtils.commonQuery(sql, day7.d_Druid.Person.class);
    }

    public Person queryById(int id) throws SQLException {
        String sql = "select * from person where id = ?";
        return runner.query(sql, new BeanHandler<>(Person.class), id);
//        List<Person> list = DaoUtils.commonQuery(sql, Person.class, id);
//        if (list.size() > 0) {
//            return list.get(0);
//        }
//        return null;
    }

    public long selectCount() throws SQLException { //查询总条数
        String sql = "select count(*) from person";
        return runner.query(sql,new ScalarHandler<>());
    }
}
