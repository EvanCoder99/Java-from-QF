package day2_MyServlet.a_servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "a", value = "/my2", loadOnStartup = 1)
public class a_httpservlet extends HttpServlet {
    //HttpServlet中有service方法
    //如果子类也重写了，则不会调用父类HttpServlet的service（调用doGet、doPost），
    //所以这里不会调用doGet、doPost，除非super
    //子类重写了service就不用写doget、dopost
    //没重写service，就会调用父类HttpServlet的service（一样会调用doGet、doPost），子类就不需要写了
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("hello service");
//        super.service(req, resp);

        request.setCharacterEncoding("utf-8"); //解决request的post乱码(get写和不写都没有乱码)

        String name = request.getParameter("username"); //获取请求参数
        String password = request.getParameter("password");
        System.out.println(name + "--" + password);
        System.out.println("请求方式：" + request.getMethod());// 获取请求方式
        System.out.println("请求路径：" + request.getRequestURI()); //获取请求路径
        request.setAttribute("name", name);  //设置属性-存值;对应使用取值
        System.out.println(request.getAttribute("name"));  //根据key取值

        //解决get/post的response方向乱码问题
        response.setContentType("text/html;charset=utf-8");
        //getWriter获取PrintWrite输出流 再调用write方法写出数据
        response.getWriter().write("返回数据");

    }

//    @Override   //访问请求 默认get
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("doGet...");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("doPost...");
//    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("自启动标签，启动tomcat时触发a_httpservice");
    }
}
