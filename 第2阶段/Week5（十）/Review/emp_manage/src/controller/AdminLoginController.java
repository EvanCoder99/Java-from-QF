package controller;


import entity.Admin;
import service.AdminService;
import service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manage/login")
public class AdminLoginController extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Admin admin = adminService.login(username, password);
        if (admin != null) {
            //设置登录凭证

            //跳转到前端
        } else {
            //提示登录失败
        }
    }
}
