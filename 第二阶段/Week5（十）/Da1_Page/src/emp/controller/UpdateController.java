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

//调用DAO层的修改操作
@WebServlet("/manage/safe/update")
public class UpdateController extends HttpServlet {
    private EmpService empService = new EmpServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端updateEmp.jsp的参数
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double salary = Double.parseDouble(req.getParameter("salary"));
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("修改："+empService.updateEmp(new Emp(id,name,salary,age)));

        //跳转到员工信息
        resp.sendRedirect(req.getContextPath() +"/manage/safe/show");

    }
}
