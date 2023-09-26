package emp.controller;

import emp.entity.Emp;
import emp.service.EmpService;
import emp.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//员工展示业务层
@WebServlet("/manage/safe/show")    // 员工的展示信息不对外开放，所以/manage/safe/*需要权限管理
public class EmpShowController extends HttpServlet {
    private EmpService empService = new EmpServiceImpl();//员工业务层

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Emp> list = empService.showEmps();
        req.setAttribute("emps",list);//request存值+转发
        //使用request原因：
        //因为数据增删改实时变动，request是一次请求有效
        //如果使用session存值，删除后数据仍然在，除非重新会话
        //转发不需要携带上下文路径/content
//        req.getRequestDispatcher("/manage/safe/showJSP").forward(req,resp);//跳转到展示页面
        req.getRequestDispatcher("/showEmps.jsp").forward(req,resp);//跳转到展示页面

    }
}
