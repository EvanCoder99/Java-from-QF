package dao;

import entity.Cart;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface CartDao {

    Cart selectCart(String pid, int uId) throws SQLException;

    int addCart(Cart cart) throws SQLException;

    int updateCart(Cart cart) throws SQLException;

    List<Cart> selectCarts(int uId) throws SQLException, InvocationTargetException, IllegalAccessException;

    int deleteById(String cid) throws SQLException;

    int clearCart(int uId) throws SQLException;
}
