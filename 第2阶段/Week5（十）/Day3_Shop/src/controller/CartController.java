package controller;

import service.CartService;
import service.impl.CartServiceImpl;
import utils.ConstUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

@WebServlet("/cart")
public class CartController extends BaseServlet{
    private CartService cartService = new CartServiceImpl();

    public String addCart(HttpServletRequest request, HttpServletResponse response) {
        int goodsId = Integer.parseInt(request.getParameter("goodsId"));
        double price = Double.parseDouble(request.getParameter("price"));

        return ConstUtils.FORWARD + "/cart.jsp";
    }

    public String show(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
