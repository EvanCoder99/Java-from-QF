package day3_ChongDingXiang.a_Login.controller;

import day3_ChongDingXiang.a_Login.entity.Admin;
import day3_ChongDingXiang.a_Login.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login_CDX")
public class AdminControl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminServiceImpl adminService = new AdminServiceImpl();

        //处理乱码
        req.setCharacterEncoding("utf-8");//解决request的post乱码
        resp.setContentType("text/html;charset=utf-8");//解决get/post的response方向乱码问题

        //从前端获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //传给业务层的登录方法
        Admin login = adminService.login(username, password);
        if (login == null) {
            resp.getWriter().write("登陆失败");
        }else{
            resp.getWriter().write("<h1>登录成功！</h1>");
            resp.getWriter().write("<a href='showAll'>展示数据</a>");
        }
    }
}
