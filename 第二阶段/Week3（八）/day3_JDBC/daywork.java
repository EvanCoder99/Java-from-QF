package day3_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class daywork {
    public static void main(String[] args) {
        /*2.添加zs,ls,ww等3条数据
        3.查询全部admin表信息
        4.以指定姓名查询*/
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //获取连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?serverTimezone=UTC", "root", "1234");

            //创建执行对象
            st = con.createStatement();

            /*String sql1 = "insert into admin (username,password,sex,love) values('zs','123','男','单身')";
            System.out.println("执行结果1："+st.executeUpdate(sql1));
            String sql2 = "insert into admin (username,password,sex,love) values('ls','123','男','结婚')";
            System.out.println("执行结果2："+st.executeUpdate(sql2));
            String sql3 = "insert into admin (username,password,sex,love) values('ww','123','男','离婚')";
            System.out.println("执行结果3："+st.executeUpdate(sql3));*/

//            String sql4 = "select * from admin";
//            ResultSet rs = st.executeQuery(sql4);
//            while (rs.next()) {
//                String id = rs.getString("id");
//                String username = rs.getString("username");
//                String sex = rs.getString("sex");
//                String love = rs.getString("love");
//                System.out.println(id+"\t"+username+"\t"+sex+"\t"+love);
//            }

            System.out.println("请输入要查询的姓名");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            String sql5 = "select * from admin where username="+"\'"+name+"\'";
            rs = st.executeQuery(sql5);
            if (rs.next()) {
                String id = rs.getString("id");
                String username = rs.getString("username");
                String sex = rs.getString("sex");
                String love = rs.getString("love");
                System.out.println(id+"\t"+username+"\t"+sex+"\t"+love);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDUtils.closeAll(st,con);
        }
    }
}
