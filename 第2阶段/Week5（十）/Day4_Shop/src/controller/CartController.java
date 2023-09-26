package controller;

import entity.Cart;
import entity.User;
import service.CartService;
import service.impl.CartServiceImpl;
import utils.ConstUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/cart")
public class CartController extends BaseServlet{
    private CartService cartService = new CartServiceImpl();

    public String creatCart(HttpServletRequest request, HttpServletResponse response) {
        //使用购物车前，进行登录判断
        User u = (User) request.getSession().getAttribute(ConstUtils.LOGIN);//获取UserController设置的凭证
        if (u == null) {
            request.setAttribute("msg","加入购物车前，请先登录！"); //login.jsp获取msg
            return ConstUtils.FORWARD+"/login.jsp";
        }

        //goodsDetail.jsp获取2个参数
        String pid = request.getParameter("pid");
        String price = request.getParameter("price");
        int res = cartService.createCart(pid,price,u.getU_id());

        return ConstUtils.REDIRECT + "/cartSuccess.jsp";
    }

    public String show(HttpServletRequest request, HttpServletResponse response) {
        //使用购物车前，进行登录判断
        User u = (User) request.getSession().getAttribute(ConstUtils.LOGIN);//获取UserController设置的凭证
        if (u == null) {
            request.setAttribute("msg","加入购物车前，请先登录！"); //login.jsp获取msg
            return ConstUtils.FORWARD+"/login.jsp";
        }

        List<Cart> list = cartService.showCarts(u.getU_id());
        request.setAttribute("carts",list); //cart.jsp获取

        return ConstUtils.FORWARD + "/cart.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response) {
        //cart.jsp获取
        String cid = request.getParameter("cid");
        String num = request.getParameter("num");
        String price = request.getParameter("price");

        int res = cartService.updateCart(cid,num,price);
        System.out.println("修改购物车："+ res);
        return ConstUtils.REDIRECT + "/cart?action=show";
    }

    //删除购物车
    public String delete(HttpServletRequest request, HttpServletResponse respons) {
        String cid = request.getParameter("cid");
        int res = cartService.deleteById(cid);
        System.out.println("删除购物车："+res);
        return ConstUtils.REDIRECT + "/cart?action=show";
    }

    //清空购物车
    public String clear(HttpServletRequest request, HttpServletResponse respons) {
        User u = (User) request.getSession().getAttribute(ConstUtils.LOGIN);//获取UserController设置的凭证
        int res = cartService.clearCart(u.getU_id());
        System.out.println("清空购物车："+res);
        return ConstUtils.REDIRECT + "/cart.jsp";
    }
}
