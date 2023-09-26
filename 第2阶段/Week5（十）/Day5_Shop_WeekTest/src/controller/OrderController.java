package controller;

import entity.Address;
import entity.Cart;
import entity.Orders;
import entity.User;
import service.AddressService;
import service.CartService;
import service.OrderService;
import service.impl.AddressServiceImpl;
import service.impl.CartServiceImpl;
import service.impl.OrderServiceImpl;
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
    private OrderService orderService = new OrderServiceImpl();

    public String preview(HttpServletRequest request, HttpServletResponse respons) {
        //UserController设置的凭证
        User u = (User) request.getSession().getAttribute(ConstUtils.LOGIN);

        List<Cart> carts = cartService.showCarts(u.getU_id());
        request.setAttribute("cartList",carts);//order.jsp获取

        List<Address> addresses = addressService.showAddress(u.getU_id());
        request.setAttribute("addList",addresses);   //order.jsp获取

        return ConstUtils.FORWARD + "/order.jsp";
    }

    public String createOrder(HttpServletRequest request, HttpServletResponse respons) {
        String aid = request.getParameter("aid");//order.jsp获取
        String sum = request.getParameter("sum");
        User user = (User) request.getSession().getAttribute(ConstUtils.LOGIN);
        int res = orderService.createOrder(aid,sum,user.getU_id());
        return ConstUtils.REDIRECT +"/order?action=show";
    }


    //展示订单
    public String show(HttpServletRequest request, HttpServletResponse respons) {
        User u = (User) request.getSession().getAttribute(ConstUtils.LOGIN);
        //根据uid获取订单的集合，订单中包含地址
        List<Orders>  list = orderService.showOrders(u.getU_id());
        //order.jsp获取
        request.setAttribute("orderList",list);

        return ConstUtils.FORWARD + "/orderList.jsp";
    }
}
