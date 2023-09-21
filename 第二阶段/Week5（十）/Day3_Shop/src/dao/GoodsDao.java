package dao;

import entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface GoodsDao {

    List<Product> selectById(int tid) throws SQLException;
    List<Product> selectByPage(int startIndex,int pageSize,int tid) throws SQLException;

    long getTotalCount(int tid) throws SQLException;

    Product selectByPid(int pid) throws SQLException;
}
