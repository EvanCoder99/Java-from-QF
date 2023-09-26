package service;

import entity.Orders;

import java.util.List;
import java.util.PrimitiveIterator;

public interface OrderService {
    int createOrder(String aid, String sum, int uId);

    List<Orders> showOrders(int uId);

    Orders showDetail(String oid);

    int updateOidState(String outTradeNo);
}
