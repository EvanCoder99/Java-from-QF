package emp.dao.impl;

import emp.dao.EmpDao;
import emp.entity.Emp;
import emp.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    private QueryRunner runner = new QueryRunner(DruidUtils.dataSource);

    @Override
    public List<Emp> selectEmp() throws SQLException {
        String sql = "select * from emp";
        return runner.query(sql,new BeanListHandler<>(Emp.class));
    }

    @Override
    public Emp selectById(int id) throws SQLException {
        String sql = "select * from emp where id=?";
        return runner.query(sql,new BeanHandler<>(Emp.class),id);
    }

    public int add(Emp emp) throws SQLException {
        String sql = "insert into emp(name,salary,age) values(?,?,?)";
        return runner.update(sql,emp.getName(),emp.getSalary(),emp.getAge());
    }

    @Override
    public int deleteByName(String name) throws SQLException {
        String sql = "delete from emp where name=?";
        return runner.update(sql,name);
    }

    @Override
    public int update(Emp emp) throws SQLException {
        String sql = "update emp set name=?,salary=?,age=? where id=?";
        return runner.update(sql,emp.getName(),emp.getSalary(),emp.getAge(),emp.getId());
    }

    @Override
    public List<Emp> selectEmpsPage(int startIndex, int pageSize) throws SQLException {
        String sql = "select * from emp limit ?,?";
        return runner.query(sql,new BeanListHandler<>(Emp.class),startIndex,pageSize);
    }

    @Override
    public long getEmpCounts() throws SQLException {
        String sql = "select count(*) from emp";
        return runner.query(sql,new ScalarHandler<>());
    }

//    public static void main(String[] args) throws SQLException {
//        List<Emp> emps = new EmpDaoImpl().selectEmpsPage(0, 5);
//        System.out.println(emps);
//    }

}
