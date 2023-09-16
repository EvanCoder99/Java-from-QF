package emp.dao.impl;

import emp.dao.EmpManagerDao;
import emp.entity.Empmanager;
import emp.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class EmpManagerDaoImpl implements EmpManagerDao {
    private QueryRunner runner = new QueryRunner(DruidUtils.dataSource);
    @Override
    public Empmanager selectByName(String name) throws SQLException {
        String sql = "select * from empManager where username=?";
        return runner.query(sql,new BeanHandler<>(Empmanager.class),name);
    }

    public static void main(String[] args) throws SQLException {
        EmpManagerDaoImpl e = new EmpManagerDaoImpl();
        Empmanager ls = e.selectByName("admin");
        System.out.println(ls);
    }
}
