package a_Seesion.a_safe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //乱码处理
        //通过过滤器，全局处理编码格式
//        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");

        String imgCode = (String) req.getSession().getAttribute("imgCode");
        if (!imgCode.equalsIgnoreCase(code)) {
            resp.getWriter().write("验证码失败");
            return;
        }

        if ("zs".equals(username) && "123".equals(password)) {
            //存凭证
            req.getSession().setAttribute("username",username);
            //跳转
            resp.sendRedirect("showAll");
        }else
            resp.getWriter().write("登陆失败");
    }
}
