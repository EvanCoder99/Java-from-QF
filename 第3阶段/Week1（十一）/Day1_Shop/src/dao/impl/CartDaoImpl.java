package dao.impl;

import dao.CartDao;
import entity.Cart;
import entity.Product;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import utils.C3P0Utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartDaoImpl implements CartDao {
    private QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

    @Override
    public Cart selectCart(String pid, int uId) throws SQLException {
        String sql = "select * from cart where p_id=? and u_id=?";
        return runner.query(sql,new BeanHandler<>(Cart.class),pid,uId);
    }

    @Override
    public int addCart(Cart c) throws SQLException {
        String sql = "insert into cart(u_id,p_id,c_count,c_num) values(?,?,?,?)";
        return runner.update(sql,c.getU_id(),c.getP_id(),c.getC_count(),c.getC_num());
    }

    //有购物车，则修改数量和小计
    @Override
    public int updateCart(Cart c) throws SQLException {
        String sql = "update cart set c_num=?,c_count=? where c_id=?";
        return runner.update(sql,c.getC_num(),c.getC_count(),c.getC_id());
    }

    @Override
    public List<Cart> selectCarts(int uId) throws SQLException, InvocationTargetException, IllegalAccessException {
        //不仅要查购物车，还有对于的商品
        //关联查询：表连接查询-内连接（两张表中能够匹配上的记录则显示出来；匹配不上的，则不显示）
        String sql = "select * from cart c inner join product p on c.p_id=p.p_id and c.u_id=?";

        //因为new BeanListHandler只能得到一个实体的集合
//        return runner.query(sql,new BeanListHandler<>(Cart.class),uId);
        //查询后返回封装Map的List集合
        //Map代表一条记录，存储2张表关联查询出来的记录，注入到实体中，
        //List存了很多Map，对应多条记录
        List<Map<String, Object>> list = runner.query(sql, new MapListHandler(), uId);
        List<Cart> carts = new ArrayList<>();

        for (Map<String, Object> m : list) {
            //只要map的key和实体属性名一致，则注入
            //1、注入到购物车
            Cart c = new Cart();
            BeanUtils.populate(c,m);

            //2、注入到商品中
            Product product = new Product();
            BeanUtils.populate(product,m);

            c.setGoods(product); //手动将商品数据设置到购物车
            carts.add(c);
        }
        return carts;
    }

    @Override
    public int deleteById(String cid) throws SQLException {
        String sql = "delete from cart where c_id=?";
        return runner.update(sql,cid);
    }

    @Override
    public int clearCart(int uId) throws SQLException {
        String sql = "delete from cart where u_id=?";
        return runner.update(sql,uId);
    }
}
