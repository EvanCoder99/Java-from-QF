package a_Seesion.c_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/context")
public class contextServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建全局对象的方式：
        //1、request对象获取  2、session对象获取  3、当前Servlet对象获取
        ServletContext context1 = req.getServletContext();
        ServletContext context2 = req.getSession().getServletContext();
        ServletContext context3 = this.getServletContext();
        System.out.println(context1 == context2);
        System.out.println(context1 == context3);

        //调用常用方法
        String realPath = context1.getRealPath("/");//获取真实路径，上传图片常用
        System.out.println("从盘符出发的路径："+realPath);
        System.out.println("context上下文路径："+context1.getContextPath());
        System.out.println("req获取上下文路径："+req.getContextPath());

        //和req、session类似，用于存值（没有req和seeion常用）
        //req：一次请求有效
        //session：一次会话有效（浏览器不变就有效）
        //context：除了关闭和重启Tomcat，其余都有效
        context1.setAttribute("key","context存值");

    }
}
