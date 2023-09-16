package a_Seesion.a_safe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showAll")
public class showAllServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        //获取session存取的值
        String username = (String) req.getSession().getAttribute("username");
        if (username != null) {
            resp.getWriter().write("展示后台数据成功!");
        }else {
            resp.sendRedirect("login.html");
        }
    }
}
