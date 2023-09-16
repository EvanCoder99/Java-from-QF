package emp.controller;

import emp.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manage/safe/delete")
public class EmpDeleteController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpServiceImpl empService = new EmpServiceImpl();

        String name = req.getParameter("name");
        if (name != null) {
            empService.deleteEmpByName(name);
            resp.sendRedirect(req.getContextPath()+"/manage/safe/show");
        }
    }
}
