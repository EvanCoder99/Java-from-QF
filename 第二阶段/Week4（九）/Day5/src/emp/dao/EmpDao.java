package emp.dao;

import emp.entity.Emp;

import java.sql.SQLException;
import java.util.List;

public interface EmpDao {
    public List<Emp> selectEmp() throws SQLException;
    public int add(Emp emp) throws SQLException;
    public int deleteByName(String name) throws SQLException;
}
