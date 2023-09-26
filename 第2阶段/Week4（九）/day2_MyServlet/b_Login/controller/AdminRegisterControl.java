package day2_MyServlet.b_Login.controller;

import day2_MyServlet.b_Login.entity.Admin;
import day2_MyServlet.b_Login.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class AdminRegisterControl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //业务层
        AdminServiceImpl adminService = new AdminServiceImpl();
        //处理乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //从前端获取数据
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String address = request.getParameter("address");

        //传给业务层的注册方法
        int register = adminService.register(username, phone, password, address);
        if (register <= 0) {
            response.getWriter().write("注册失败");
        }else
            response.getWriter().write("注册成功");
    }
}
