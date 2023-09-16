package day3_ChongDingXiang.yuanawen.one;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login2")
public class loginControl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //从前端获取参数
        String username = req.getParameter("username");

        if ("zs".equals(username)) {
            resp.getWriter().write("登陆成功");
            req.getRequestDispatcher("print").forward(req,resp);    //跳转到打印cookie界面
            req.setAttribute("username",username);
        }else{
            resp.getWriter().write("登陆失败");
        }
    }
}
