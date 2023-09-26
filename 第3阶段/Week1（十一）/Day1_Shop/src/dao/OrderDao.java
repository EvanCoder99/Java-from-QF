package dao;

import entity.Item;
import entity.Orders;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    int addOrder(Orders orders) throws SQLException;

    int batchItems(List<Item> items) throws SQLException;

    List<Orders> selectOrders(int uId) throws SQLException, InvocationTargetException, IllegalAccessException;

    Orders selectOrdersByOid(String oid) throws SQLException, InvocationTargetException, IllegalAccessException;

    List<Item> selectIteamsByOid(String oid) throws InvocationTargetException, IllegalAccessException, SQLException;

    int updateOidState(String oid) throws SQLException;
}
