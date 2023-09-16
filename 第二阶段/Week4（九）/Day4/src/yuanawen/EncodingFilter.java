package yuanawen;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest res = (HttpServletRequest) servletRequest;
        String uri = res.getRequestURI();

        if (!uri.endsWith(".html")) {
            servletRequest.setCharacterEncoding("utf-8");
            servletResponse.setContentType("text/html;charset=utf-8");
        }
        filterChain.doFilter(servletRequest,servletResponse);//放行
    }

    @Override
    public void destroy() {

    }
}
