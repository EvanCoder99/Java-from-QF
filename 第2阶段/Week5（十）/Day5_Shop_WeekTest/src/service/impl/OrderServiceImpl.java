package service.impl;

import dao.CartDao;
import dao.OrderDao;
import dao.impl.CartDaoImpl;
import dao.impl.OrderDaoImpl;
import entity.Cart;
import entity.Item;
import entity.Orders;
import service.OrderService;
import utils.RandomUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private CartDao cartDao = new CartDaoImpl();
    @Override
    public int createOrder(String aid, String sum, int uId) {
        int res = 0;
        try {
            //1、添加订单
            Orders orders = new Orders();
            String oid = RandomUtils.createOrderId();//获取订单id
            orders.setO_id(oid);    //设置oid
            orders.setA_id(Integer.parseInt(aid));//设置地址id
            orders.setO_count(new BigDecimal(sum));//设置总金额
            orders.setO_state(1);   //设置状态，orderList.jsp设置好了，1-4，1未支付
            orders.setU_id(uId);    //设置用户id
            orders.setO_time(new Date()); //创建订单时间，也可以传参now()，在SQL语句内使用数据库函数
            res = orderDao.addOrder(orders);
            System.out.println("添加订单："+res);


            //2、添加订单详情，一个订单有多个详情，批处理
            List<Item> items = new ArrayList<>();
            List<Cart> carts = cartDao.selectCarts(uId);
            //遍历购物车，将数据存入items订单详情
            for (Cart c : carts) {
                Item it = new Item(0,oid,c.getP_id(),c.getC_count(),c.getC_num());
                items.add(it);//存入订单详情
            }

            //批处理详情
            res = orderDao.batchItems(items);
            System.out.println("详情批处理："+res);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Orders> showOrders(int uId) {
        try {

            return orderDao.selectOrders(uId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
