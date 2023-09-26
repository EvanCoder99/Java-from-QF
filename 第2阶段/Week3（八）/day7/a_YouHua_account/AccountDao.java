package day7.a_YouHua_account;

import Utils.JDUtilsProperties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDao {
    public Account selectCart(String cart) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = JDUtilsProperties.getConnection();
            String sql = "select * from account where cart = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,cart);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");
                int money = rs.getInt("money");
                return new Account(id, cart, password, money);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            JDUtilsProperties.closeAll(ps,rs,con);
            JDUtilsProperties.closeAll(ps,rs);//使用事务时，在DAO层不要关闭连接对象，事务回滚后再关闭

        }
        return null;
    }

    public int updataAccMoney(Account a) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = JDUtilsProperties.getConnection();
            String sql = "update account set money = ? where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,a.getMoney());
            ps.setInt(2,a.getId());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            JDUtilsProperties.closeAll(ps,con);
            JDUtilsProperties.closeAll(ps);//使用事务时，在DAO层不要关闭连接对象，事务回滚后再关闭
        }
        return 0;
    }

    public int updataAcceptAcc(Account acceptAccount) {
        return 0;
    }
}
