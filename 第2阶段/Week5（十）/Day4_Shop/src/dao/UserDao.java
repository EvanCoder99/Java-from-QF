package dao;

import entity.User;

import java.sql.SQLException;

public interface UserDao {
    public User selectByName(String name) throws SQLException;

    public int addUser(User user) throws SQLException;

    public User selectByCode(String code) throws SQLException;

    public int updateStatus(int id) throws SQLException;
}
