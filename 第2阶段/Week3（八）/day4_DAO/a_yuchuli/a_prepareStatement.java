package day4_DAO.a_yuchuli;


import Utils.JDUtils;

import java.sql.*;
import java.util.Scanner;

public class a_prepareStatement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名:");
        //next则字符串空格则结束  nextLine允许有空格，例如“zs f”是一个用户名
        String username = sc.nextLine();
        System.out.print("请输入密码:");
        String password = sc.nextLine();
        if(login(username,password)){ //调用登录功能
            System.out.println("登录成功~~！");
        }else{
            System.out.println("登录失败~~！");
        }
    }
    private static boolean login(String username, String password) {
        Connection conn = null;
        PreparedStatement ps   = null;
        ResultSet rs   = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.通过驱动管理器获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?serverTimezone=UTC", "root", "1234");
            //3.创建执行对象
            String sql = "select count(*) from user where username= ? and password= ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);

            rs = ps.executeQuery();
            if(rs.next()){
                //rs.getInt(1):获取第一个字段 count(*)字段   聚合函数：0或大于0
                return rs.getInt(1)>0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDUtils.closeAll(rs,ps,conn);
        }
        return false;
    }
}
