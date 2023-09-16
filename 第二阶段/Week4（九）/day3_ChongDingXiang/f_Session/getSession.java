package day3_ChongDingXiang.f_Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/getsess")
public class getSession extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("get sessionID："+session.getId());
        //如果设置seesion后关闭了浏览器，则此处取不到值
        System.out.println("取值："+session.getAttribute("username"));
    }
}
