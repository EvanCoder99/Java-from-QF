package emp.dao;

import emp.entity.Empmanager;

import java.sql.SQLException;

public interface EmpManagerDao {
    public Empmanager selectByName(String name) throws SQLException;
}
