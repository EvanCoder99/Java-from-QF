package day3_ChongDingXiang.b_Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/a")
public class AServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了A  Service");

        //一、仅跳转，不带数据
        //转发——跳转到BServlet  服务器内部跳转
//        req.getRequestDispatcher("b").forward(req,resp);
        //重定向——跳转到BServlet，客户端会重新发出跳转请求
//        resp.sendRedirect("b");

        //结论：跳转可以使用这两种，基本上没太大区别；关键在于传数据

        //二、跳转 + 传数据
        //req存储数据，参数1：key 参数2：value
        req.setAttribute("key","my data");
        //转发传输数据
//        req.getRequestDispatcher("b").forward(req,resp);
        //重定向（传输数据为null）
        resp.sendRedirect("b");

    }
}
