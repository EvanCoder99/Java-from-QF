package dao;

import entity.Admin;

import java.sql.SQLException;

public interface AdminDao {
    Admin selectByName(String name) throws SQLException;
}
