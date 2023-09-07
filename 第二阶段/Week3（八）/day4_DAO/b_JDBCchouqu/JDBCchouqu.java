package day4_DAO.b_JDBCchouqu;

import Utils.JDUtils;
import Utils.JDUtilsProperties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JDBCchouqu {
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
            //封装连接JDBC，获取连接对象
//            conn = JDUtils.getConnection();
            conn = JDUtilsProperties.getConnection();
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
