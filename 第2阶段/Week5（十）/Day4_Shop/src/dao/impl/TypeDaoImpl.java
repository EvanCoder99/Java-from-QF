package dao.impl;

import dao.TypeDao;
import entity.Type;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class TypeDaoImpl implements TypeDao {
    private QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
    @Override
    public List<Type> selectTypes() throws SQLException {
        String sql = "select * from type";
        return runner.query(sql,new BeanListHandler<>(Type.class));
    }
}
