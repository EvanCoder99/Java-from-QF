package dao.impl;

import dao.GoodsDao;
import entity.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    private QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
    @Override
    public List<Product> selectById(int tid) throws SQLException {
        String sql = "select * from product where t_id=?";
        return runner.query(sql,new BeanListHandler<>(Product.class),tid);
    }

    @Override
    public List<Product> selectByPage(int startIndex, int pageSize,int tid) throws SQLException {
        String sql = "select * from product where t_id=? limit ?,?";
        return runner.query(sql,new BeanListHandler<>(Product.class),tid,startIndex,pageSize);
    }

    @Override
    public long getTotalCount(int tid) throws SQLException {
        String sql = "select count(*) from product where t_id=?";
        return (long)runner.query(sql,new ScalarHandler(),tid);
    }

    @Override
    public Product selectByPid(int pid) throws SQLException {
        String sql = "select * from product where p_id = ?";
        return runner.query(sql,new BeanHandler<>(Product.class),pid);
    }

}
