package dao;

import entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {
    List<Address> selectAddress(int u_id) throws SQLException;

    int addAddress(Address address) throws SQLException;

    int deleteByAId(String aid) throws SQLException;

    int updateAddress(Address address) throws SQLException;

    int updateNoDefaultByUid(int uId) throws SQLException;

    int updateDefaultByUid(String aid) throws SQLException;
}
