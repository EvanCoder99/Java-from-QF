package service;

import entity.Cart;

import java.util.List;

public interface CartService {

    int createCart(String pid, String price, int uId);

    List<Cart> showCarts(int uId);

    int updateCart(String cid, String num, String price);

    int deleteById(String cid);

    int clearCart(int uId);
}
