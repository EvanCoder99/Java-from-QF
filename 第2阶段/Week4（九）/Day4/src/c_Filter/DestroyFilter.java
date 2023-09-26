package c_Filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/dest")
//@WebFilter("/*")  //通配符匹配-常用  /xx/yy/* - 常用(多级路径)
//@WebFilter("/.xxx")
public class DestroyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入过滤器...开始");
        filterChain.doFilter(servletRequest,servletResponse);  //放行
        System.out.println("进入过滤器...结束");
    }

    @Override
    public void destroy() {

    }
}
