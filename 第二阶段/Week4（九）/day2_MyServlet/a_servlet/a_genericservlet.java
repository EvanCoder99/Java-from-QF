package day2_MyServlet.a_servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/my1")  //注解访问，会自动生成
public class a_genericservlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello GenricService");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("自启动a_genericservlet");
    }
}
