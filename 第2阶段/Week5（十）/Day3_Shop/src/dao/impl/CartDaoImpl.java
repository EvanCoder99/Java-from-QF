package dao.impl;

import dao.CartDao;
import entity.Cart;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class CartDaoImpl implements CartDao {
    private QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
    @Override
    public int add(Cart cart) throws SQLException {
        String sql = "insert into cart(u_id,p_id,c_count,c_num) values(?,?,?,?)";
        return runner.update(sql,cart.getU_id(),cart.getP_id(),cart.getC_count(),cart.getC_num());
    }

    @Override
    public List<Cart> queryByCartId(int cartId) throws SQLException {
        String sql = "select * from cart where c_id=?";
        return runner.query(sql,new BeanListHandler<>(Cart.class),cartId);
    }
}
