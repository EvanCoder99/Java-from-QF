package dao;

import entity.Type;

import java.sql.SQLException;
import java.util.List;

public interface TypeDao {
    List<Type> selectTypes() throws SQLException;
}
