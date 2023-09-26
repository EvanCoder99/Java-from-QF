package day3_ChongDingXiang.e_Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setcook")
public class setCookie extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("name", "张三丰");
        cookie.setMaxAge(60*60*24); //单位秒

        //设置cookie：从服务器设置到客户端--resp
        resp.addCookie(cookie);
        resp.getWriter().write("cookie success");
    }
}
