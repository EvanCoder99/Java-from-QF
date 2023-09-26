package dao.impl;

import com.sun.org.apache.bcel.internal.generic.POP;
import dao.OrderDao;
import entity.Address;
import entity.Item;
import entity.Orders;
import entity.Product;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import utils.C3P0Utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl implements OrderDao {
    private QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
    @Override
    public int addOrder(Orders o) throws SQLException {
        String sql = "insert into orders(o_id,a_id,o_count,o_state,u_id,o_time) values(?,?,?,?,?,?)";
        return runner.update(sql,o.getO_id(),o.getA_id(),o.getO_count(),o.getO_state(),o.getU_id(),o.getO_time());
    }

    @Override
    public int batchItems(List<Item> items) throws SQLException {
        String sql = "insert into item(o_id,p_id,i_count,i_num) values(?,?,?,?)";
        Object[][] objs = new Object[items.size()][];
        for (int i = 0; i < items.size(); i++) {
            //获取Item订单详情对象
            Item it = items.get(i);
            //里面的值由SQL的占位符决定
            objs[i] = new Object[]{it.getO_id(),it.getP_id(),it.getI_count(),it.getI_num()};
        }
        
        return runner.batch(sql,objs).length;   //返回的是数组
    }

    @Override
    public List<Orders> selectOrders(int uId) throws SQLException, InvocationTargetException, IllegalAccessException {
        //需要关联订单表与地址表
        String sql = "select * from orders o inner join address a on o.a_id=a.a_id and a.u_id=?";
        List<Map<String, Object>> query = runner.query(sql, new MapListHandler(), uId);
        List<Orders> list = new ArrayList<>();

        //循环遍历List集合，和购物车注入实体一样
        for (Map<String, Object> m : query) {

            Orders o = new Orders();
            BeanUtils.populate(o,m);

            Address addr = new Address();
            BeanUtils.populate(addr,m);

            o.setAddress(addr);
            list.add(o);
        }
        return list;
    }

    @Override
    public Orders selectOrdersByOid(String oid) throws SQLException, InvocationTargetException, IllegalAccessException {
        //查询订单和地址的关联
        String sql = "select * from orders o inner join address a on o.a_id=a.a_id and o.o_id=?";
        Map<String, Object> map = runner.query(sql, new MapHandler(), oid);

        Orders o = new Orders();
        BeanUtils.populate(o,map);//值的注入

        Address a = new Address();
        BeanUtils.populate(a,map);

        //将地址放入订单对象中
        o.setAddress(a);
        return o;
    }

    @Override
    public List<Item> selectIteamsByOid(String oid) throws InvocationTargetException, IllegalAccessException, SQLException {
        //订单详情与商品的关联
        String sql = "select * from item i inner join product p " +
                "on i.p_id=p.p_id and i.o_id=?";
        List<Map<String, Object>> query = runner.query(sql, new MapListHandler(), oid);
        List<Item> items = new ArrayList<>();
        for(Map<String, Object> map:query){
            Item item = new Item();
            BeanUtils.populate(item,map);
            Product product = new Product();
            BeanUtils.populate(product,map);
            item.setGoods(product);
            items.add(item);
        }
        return items;
    }

    @Override
    public int updateOidState(String oid) throws SQLException {
        String sql = "update orders set o_state=2 where o_id=?";
        return  runner.update(sql,oid);
    }
}
