package day1_Servlet.WeekTest;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoUtils {
    public static int update(String sql,Object...o){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < o.length; i++) {
                ps.setObject(i+1,o[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(ps,con);
        }
        return 0;
    }

    public static <T> List<T> query(String sql,Class<T> clazz, Object...o) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();

        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < o.length; i++) {
                ps.setObject(i+1,o[i]);
            }
            rs = ps.executeQuery();
            Field[] fields = clazz.getDeclaredFields();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (Field f : fields) {
                    //获取表中的字段，注入到实体属性中，就是ORM
                    Object value = rs.getObject(f.getName());
                    f.setAccessible(true);
                    f.set(t,value);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return list;
    }

}
