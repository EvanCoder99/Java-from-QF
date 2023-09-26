package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String username = (String) req.getSession().getAttribute("username");
        System.out.println("凭证："+username);

        String uri = req.getRequestURI();
        System.out.println("URI："+uri);
        //判断如果有凭证，或者是登录的前端、后端判断页面,以及验证码都放行
        if (username != null || uri.contains("login") || "login".equals(req.getParameter("action"))) {
            filterChain.doFilter(req, resp);
        } else {
            resp.sendRedirect("/admin/login.jsp"); //重定向到登录界面
        }

    }

    @Override
    public void destroy() {

    }
}
