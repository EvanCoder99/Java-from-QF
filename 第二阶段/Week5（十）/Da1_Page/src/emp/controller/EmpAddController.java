package emp.controller;

import emp.entity.Emp;
import emp.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manage/safe/add")
public class EmpAddController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpServiceImpl empService = new EmpServiceImpl();

        String username = req.getParameter("username");
        double salary = Double.parseDouble(req.getParameter("salary"));
        int age = Integer.parseInt(req.getParameter("age"));


        Emp emp = new Emp(1, username, salary, age);
        empService.addEmp(emp);
        resp.sendRedirect(req.getContextPath()+"/manage/safe/show");

    }
}
