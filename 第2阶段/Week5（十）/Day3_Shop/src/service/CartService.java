package service;

import entity.Cart;

public interface CartService {
    public int addCart(Cart cart);
    public Cart getCart();
}
