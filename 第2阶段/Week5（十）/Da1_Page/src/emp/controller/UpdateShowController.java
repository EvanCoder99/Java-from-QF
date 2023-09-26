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

//展示修改数据，根据updateEmp.jsp传入的ID，返回修改记录
@WebServlet("/manage/safe/showEmp")
public class UpdateShowController extends HttpServlet {
    private EmpService empService = new EmpServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从前端showEmps.jsp获取要修改员工的id
        int id = Integer.parseInt(req.getParameter("id"));
        Emp emp = empService.selectById(id);
        req.setAttribute("emp",emp);//存值，等待JSP取出来操作
        req.getRequestDispatcher("/updateEmp.jsp").forward(req,resp);
    }
}
