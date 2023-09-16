package a_Seesion.c_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get")
public class getContext extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、request对象获取  2、session对象获取  3、当前Servlet对象获取
        ServletContext context1 = req.getServletContext();
        ServletContext context2 = req.getSession().getServletContext();
        ServletContext context3 = this.getServletContext();

        System.out.println("获取值："+context1.getAttribute("key"));

        System.out.print("清除key：");
        context1.removeAttribute("key");//只是移除存储的值，context对象还在，session和req也类似
    }
}
