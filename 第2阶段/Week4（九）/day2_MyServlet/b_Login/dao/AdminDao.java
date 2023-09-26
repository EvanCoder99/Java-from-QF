package day2_MyServlet.b_Login.dao;

import day2_MyServlet.b_Login.entity.Admin;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {
    public Admin queryByName(String name) throws SQLException;
    public List<Admin> queryAdmins() throws SQLException;
    public int addAdmin(Admin admin) throws SQLException;
    public int updateAdmin(Admin admin);
    public int deleteByName(String name);
}
