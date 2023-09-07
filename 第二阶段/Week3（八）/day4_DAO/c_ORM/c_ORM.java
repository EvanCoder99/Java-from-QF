package day4_DAO.c_ORM;

import Utils.JDUtilsProperties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class c_ORM {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<c_Jobs> list = new ArrayList<>();
        try {

            con = JDUtilsProperties.getConnection();
            ps = con.prepareStatement("select * from t_jobs");
            rs = ps.executeQuery();

            while (rs.next()) {
                String job_id = rs.getString("job_id");
                String job_title = rs.getString("job_title");
                String min_salary = rs.getString("min_salary");
                String max_salary = rs.getString("max_salary");

                //OMR操作：将零散的数据封装成一个实体
                c_Jobs jobs = new c_Jobs(job_id,job_title,max_salary,min_salary);
                list.add(jobs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDUtilsProperties.closeAll(rs,ps,con);
        }
        System.out.println(list);
    }
}
