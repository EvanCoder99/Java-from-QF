package day7.yuanawen;

import day7.c_DAOUtils.DBUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoUtils {
    public static int Update(String sql,Object...objs) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i+1,objs[i]);
            }
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(ps,con);
        }
        return 0;
    }

    public static <T> List<T> Query(String sql,Class<T> clazz, Object...objs) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i+1,objs[i]);
            }
            rs = ps.executeQuery();
            Field[] fields = clazz.getDeclaredFields();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (Field f : fields) {
                    Object value = rs.getObject(f.getName());
                    f.setAccessible(true);
                    f.set(t,value);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(ps,rs,con);
        }
        return list;
    }
}
