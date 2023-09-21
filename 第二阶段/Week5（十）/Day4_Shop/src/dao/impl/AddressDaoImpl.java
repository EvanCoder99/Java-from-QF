package dao.impl;

import dao.AddressDao;
import entity.Address;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Stream;

public class AddressDaoImpl implements AddressDao {
    private QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
    @Override
    public List<Address> selectAddress(int u_id) throws SQLException {
//        String sql = "select * from address where u_id=? order by a_state desc";
        String sql = "select * from address where u_id=?";
        return runner.query(sql,new BeanListHandler<>(Address.class),u_id);
    }

    @Override
    public int addAddress(Address a) throws SQLException {
        String sql = "insert into address(u_id,a_name,a_phone,a_detail,a_state) values(?,?,?,?,?)";
        return runner.update(sql,a.getU_id(),a.getA_name(),a.getA_phone(),a.getA_detail(),a.getA_state());
    }

    @Override
    public int deleteByAId(String aid) throws SQLException {
        String sql = "delete from address where a_id=?";
        return runner.update(sql,aid);
    }

    @Override
    public int updateAddress(Address a) throws SQLException {
        String sql = "update address set a_name=?,a_phone=?,a_detail=? where a_id=?";
        return runner.update(sql,a.getA_name(),a.getA_phone(),a.getA_detail(),a.getA_id());
    }

    @Override
    public int updateNoDefaultByUid(int uId) throws SQLException {
        String sql = "update address set a_state=0 where u_id=?";
        return runner.update(sql,uId);
    }

    @Override
    public int updateDefaultByUid(String aid) throws SQLException {
        String sql = "update address set a_state=1 where a_id=?";
        return runner.update(sql,aid);
    }

}
