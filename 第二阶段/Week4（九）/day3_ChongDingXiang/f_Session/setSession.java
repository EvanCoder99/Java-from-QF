package day3_ChongDingXiang.f_Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/setsess")
public class setSession extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //首次访问则创建，不是则获取对象
        HttpSession session = req.getSession();
        System.out.println("seesionID："+session.getId());

        //在session域中存值
        session.setAttribute("username","凤姐");
    }
}
