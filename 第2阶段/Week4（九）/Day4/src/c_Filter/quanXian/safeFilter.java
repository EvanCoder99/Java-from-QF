package c_Filter.quanXian;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/*")    //都是/*，EncodingFilter过滤器会比safeServlet先执行
public class safeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //注意：
        //此时通过servletRequest调用getSession()无法获取session对象！
        //HttpServletRequest 是 ServletRequest的子类
        //只有HttpServletRequest才能调用
        //父转子：ServletRequest——>HttpServletRequest，强转往往会有隐患，但此处为什么没有问题？
        //因为：发送的请求是Http的请求，所以本身就是HttpServletRequest，只不过形参用父类接收（多态）
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String username = (String) req.getSession().getAttribute("username");

        String uri = req.getRequestURI();//获取请求路径
        System.out.println("URI："+uri);
        //判断如果有凭证，或者是登录的前端、后端判断页面,以及验证码都放行
        if (username != null || uri.contains("login")||uri.contains("/valid")) { //取到了凭证，则放行
            //servletRequest和servletResponse也可以，因为是同一个对象；只是后者使用父类接收
            filterChain.doFilter(req, resp);
        } else {
            resp.sendRedirect("login.html"); //重定向到登录界面
        }
    }

    @Override
    public void destroy() {

    }
}
