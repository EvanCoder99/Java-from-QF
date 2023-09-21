package dao;

import entity.Cart;

import java.sql.SQLException;
import java.util.List;

public interface CartDao {
    int add(Cart cart) throws SQLException;
    List<Cart> queryByCartId(int cartId) throws SQLException;
}
