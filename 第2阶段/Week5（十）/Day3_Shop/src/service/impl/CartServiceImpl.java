package service.impl;

import dao.CartDao;
import dao.impl.CartDaoImpl;
import entity.Cart;
import service.CartService;

import java.sql.SQLException;

public class CartServiceImpl implements CartService {
    private CartDao cartDao = new CartDaoImpl();

    @Override
    public int addCart(Cart c) {
        try {
            return cartDao.add(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Cart getCart() {
        return null;
    }
}
