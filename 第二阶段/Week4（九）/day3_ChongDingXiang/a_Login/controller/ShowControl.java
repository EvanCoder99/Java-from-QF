package day3_ChongDingXiang.a_Login.controller;

import day3_ChongDingXiang.a_Login.entity.Admin;
import day3_ChongDingXiang.a_Login.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//@WebServlet("/showAll")
public class ShowControl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8"); //响应乱码

        //调用业务层，完成展示数据功能
        List<Admin> list = new AdminServiceImpl().showAdmins();
        if (list != null) {
            request.setAttribute("admins",list);
            request.getRequestDispatcher("ShowJSP").forward(request,response);
        }else {
            response.getWriter().write("数据未找到");
        }
    }
}
