package dao.impl;

import dao.OrderDao;
import entity.Address;
import entity.Item;
import entity.Orders;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
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
}
