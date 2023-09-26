package day7.c_DAOUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoUtils {
    public static int commonUpdate(String sql,Object...objs){
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

    //不推荐用Object，因为还要强转
    //因为要将字段值注入到实体属性中，所以要用反射
    public static <T> List<T> commonQuery(String sql,Class<T> clazz,Object...objs){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();

        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) { //设置问号的参数
                ps.setObject(i+1,objs[i]);
            }
            rs = ps.executeQuery();
            Field[] fields = clazz.getDeclaredFields(); //获取所有属性

            while (rs.next()) {
                T t = clazz.newInstance();
                for (Field f : fields) {
                    //获取表中的字段，存到实体属性中，就是ORM
                    Object value = rs.getObject(f.getName());//将属性充当字段获取字段值
                    f.setAccessible(true);
                    f.set(t,value);    //给该对象的属性赋值
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs,ps,con);
        }
        return list;
    }
}
