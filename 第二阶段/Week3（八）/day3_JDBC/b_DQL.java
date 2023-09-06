package day3_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class b_DQL {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?serverTimezone=UTC","root","1234");

            st = con.createStatement();
            String sql = "select * from t_jobs";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String job_id = rs.getString("job_id");
                String job_title = rs.getString("job_title");
                String min_salary = rs.getString("min_salary");
                String max_salary = rs.getString("max_salary");
                System.out.println(job_id+ "\t" +job_title+ "\t" +max_salary+ "\t" +max_salary+"\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDUtils.closeAll(rs,st,con);
        }
    }
}
