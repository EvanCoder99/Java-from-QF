package controller;

import utils.ConstUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        String action = req.getParameter("action");
        if ("login".equals(action)) {
            login();
        }else if("register".equals(action)){
            ...违背开闭原则，维护性差，所以使用反射
        */

        String action = req.getParameter("action");
        if (action == null) {   //没有取到action值，进入首页，例如http://localhost:8080/user?actio=xx，action写错
            action = "index";
        }

        //使用对象.getClass，哪个模块访问service，反射对象就代表谁；
        //例如访问user，就会产生user的controller对象，而这个对象没有重写service方法，就会调用父类
        try {
            Class clazz = this.getClass();
            Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            Object o = method.invoke(this, req, resp); //调用指定功能，action是谁，调用的就是哪个名字

            if (o != null) {
                String res = (String) o;
                //选择跳转方式
                if (res.contains(ConstUtils.REDIRECT)) { //重定向redirect
                    String path = res.split(":")[1];    //redirect:/show.jsp
                    resp.sendRedirect(req.getContextPath() + path);
                } else if (res.contains(ConstUtils.FORWARD)) {   //转发forward
                    String path = res.split(":")[1];    //forward:/show.jsp
                    req.getRequestDispatcher(path).forward(req,resp);
                } else {
                    resp.getWriter().write(res);
                }
            }

        } catch (Exception e) {
            System.out.println("映射路径访问出现异常");
            e.printStackTrace();
        }
    }

    public String index(HttpServletRequest req,HttpServletResponse resp){
        System.out.println("参数异常，进入首页");
        return ConstUtils.FORWARD+"index.jsp";
    }
}
