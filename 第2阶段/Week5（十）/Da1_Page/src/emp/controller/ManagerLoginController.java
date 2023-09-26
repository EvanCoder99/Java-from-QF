package emp.controller;

import emp.entity.Empmanager;
import emp.service.EmpManagerService;
import emp.service.impl.EmpManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manage/login")    //需要放行，所以不需要加/safe
public class ManagerLoginController extends HttpServlet {
    private EmpManagerService empManagerService = new EmpManagerServiceImpl();//员工管理员业务层
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前段参数，交给管理员业务层
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //获取返回的管理员对象
        Empmanager empmanager = empManagerService.login(username, password);
        if (empmanager != null) {
            //设置登录凭证———在权限验证、展示用户信息等其他功能使用
            req.getSession().setAttribute("em",empmanager);
            //登陆成功，跳转员工展示页面
            //如果没写上下文路径，就是空的
            //如果写了上下文路径，就需要获取一下，因为重定向不会帮忙拼接或者自动生成
            //并且，如果manage前面没有"/"，就是相对路径，会相对于上一次的路径继续拼接，造成路径越拼越长，因为每次都是相对于上一次的xxx路径
            //结论：在多级路径中，不适合相对路径！！！
            //使用重定向和转发都行，区别在于路径显示不一样，重定向可以明确看到路径的变化，转发不行
            resp.sendRedirect(req.getContextPath()+"/manage/safe/show");       //http://localhost:8080/emp/manage/safe/show
//            req.getRequestDispatcher("/manage/safe/show").forward(req,resp);  //http://localhost:8080/emp/manage/login?username=admin&password=admin
        }else {
            resp.getWriter().write("登陆失败");
            //优化：跳转到登录界面
        }
    }
}
