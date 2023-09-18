package emp.dao;

import emp.entity.Emp;

import java.sql.SQLException;
import java.util.List;

public interface EmpDao {
    public List<Emp> selectEmp() throws SQLException;
    public Emp selectById(int id) throws SQLException;
    public int add(Emp emp) throws SQLException;
    public int deleteByName(String name) throws SQLException;
    public int update(Emp emp) throws SQLException;
    //分页功能
    public List<Emp> selectEmpsPage(int startIndex, int pageSize) throws SQLException;

    public long getEmpCounts() throws SQLException;
}
