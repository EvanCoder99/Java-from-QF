package c_Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")    //访问任何Servlet都会经过过滤器，处理编码
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest res = (HttpServletRequest) servletRequest;
        String uri = res.getRequestURI();

        if (!uri.endsWith(".html")) {
            System.out.println("进入编码处理....");
            servletRequest.setCharacterEncoding("utf-8");
            servletResponse.setContentType("text/html;charset=utf-8");
        }
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
