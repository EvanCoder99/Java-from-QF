package controller;

import entity.Address;
import entity.Cart;
import entity.User;
import service.AddressService;
import service.CartService;
import service.impl.AddressServiceImpl;
import service.impl.CartServiceImpl;
import utils.ConstUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/order")
public class OrderController extends BaseServlet{
    //需要反馈购物车与地址的集合，此处需要购物车业务、地址业务
    private CartService cartService = new CartServiceImpl();
    private AddressService addressService = new AddressServiceImpl();

    public String preview(HttpServletRequest request, HttpServletResponse respons) {
        //UserController设置的凭证
        User u = (User) request.getSession().getAttribute(ConstUtils.LOGIN);

        List<Cart> carts = cartService.showCarts(u.getU_id());
        request.setAttribute("cartList",carts);//order.jsp获取

        List<Address> addresses = addressService.showAddress(u.getU_id());
        request.setAttribute("addList",addresses);   //order.jsp获取

        return ConstUtils.FORWARD + "/order.jsp";
    }
}
