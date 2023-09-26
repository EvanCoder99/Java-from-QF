package controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import config.AlipayConfig;
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
import java.io.UnsupportedEncodingException;
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

    //订单展示详情
    public String showDetail(HttpServletRequest request, HttpServletResponse respons) {
        String oid = request.getParameter("oid"); //orderDetail.jsp
        Orders orders = orderService.showDetail(oid);
        request.setAttribute("od",orders);
        return ConstUtils.FORWARD+"/orderDetail.jsp";
    }


    public String pay(HttpServletRequest request, HttpServletResponse respons) throws UnsupportedEncodingException, AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
        //付款金额，必填
        String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
        //订单名称，必填
        String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
        //商品描述，可空
        String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        return result;
    }

}
