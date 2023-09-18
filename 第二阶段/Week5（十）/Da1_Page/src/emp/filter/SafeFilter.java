package emp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/manage/safe/*")
public class SafeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //ManagerLoginController存入的登录凭证
        Object em = req.getSession().getAttribute("em");
        if (em != null) {
            //存储凭证，放行
            filterChain.doFilter(req, resp);
        } else {
            //没有登录凭证，跳转到登录页面
            resp.sendRedirect(req.getContextPath() + "/login.html");
        }
    }

    @Override
    public void destroy() {

    }
}
