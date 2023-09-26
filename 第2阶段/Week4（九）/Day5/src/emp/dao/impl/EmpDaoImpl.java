package emp.dao.impl;

import emp.dao.EmpDao;
import emp.entity.Emp;
import emp.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    private QueryRunner runner = new QueryRunner(DruidUtils.dataSource);

    @Override
    public List<Emp> selectEmp() throws SQLException {
        String sql = "select * from emp";
        return runner.query(sql,new BeanListHandler<>(Emp.class));
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

//    public static void main(String[] args) throws SQLException {
//        EmpDaoImpl empDao = new EmpDaoImpl();
//        List<Emp> emps = empDao.addEmp();
//        System.out.println(emps);
//    }
}
