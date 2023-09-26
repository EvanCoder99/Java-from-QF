package service.impl;

import dao.CartDao;
import dao.impl.CartDaoImpl;
import entity.Cart;
import service.CartService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class CartServiceImpl implements CartService {
    private CartDao cartDao = new CartDaoImpl();

    //1.根据匹配uid与pid，查找是否有对应的购物车
    @Override
    public int createCart(String pid, String price, int uId) {
        int res = 0;
        //创建购物车前，先判断是否有购物车，没有则添加
        try {
            Cart cart  = cartDao.selectCart(pid,uId);
            if (cart == null) {

                cart = new Cart();
                cart.setU_id(uId);
                cart.setP_id(Integer.parseInt(pid));
                cart.setC_count(new BigDecimal(price));
                cart.setC_num(1);
                res = cartDao.addCart(cart);
                System.out.println("添加购物车：" + res);

            } else {    //有购物车，则修改数量和小计

                cart.setC_num(cart.getC_num()+1);   //数量+1
                BigDecimal big = new BigDecimal(price);
                cart.setC_count(big.multiply(new BigDecimal(cart.getC_num()+"")));
                //修改购物车
                res = cartDao.updateCart(cart);
                System.out.println("修改购物车："+res);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Cart> showCarts(int uId) {
        try {
            return cartDao.selectCarts(uId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateCart(String cid, String num, String price) {
        try {
            Cart cart = new Cart();
            cart.setC_id(Integer.parseInt(cid));
            cart.setC_num(Integer.parseInt(num));
            BigDecimal big = new BigDecimal(price);
            //小计=数量*价格
            cart.setC_count(big.multiply(new BigDecimal(num)));

            return cartDao.updateCart(cart);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteById(String cid) {
        try {
            return cartDao.deleteById(cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int clearCart(int uId) {
        try {
            return cartDao.clearCart(uId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
