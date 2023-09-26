package dao.impl;

import dao.AdminDao;
import entity.Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DruidUtils;

import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    private QueryRunner runner = new QueryRunner(DruidUtils.dataSource);
    @Override
    public Admin selectByName(String name) throws SQLException {
        String sql = "select * from admin where username=?";
        return runner.query(sql,new BeanHandler<>(Admin.class),name);
    }
}
