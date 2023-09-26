package dao;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public User selectByName(String name) throws SQLException;

    public int addUser(User user) throws SQLException;

    public User selectByCode(String code) throws SQLException;

    public int updateStatus(int id) throws SQLException;

    List<User> selectUser() throws SQLException;

    int deleteUser(String uId) throws SQLException;

    List<User> searchByName(String uName) throws SQLException;

}
