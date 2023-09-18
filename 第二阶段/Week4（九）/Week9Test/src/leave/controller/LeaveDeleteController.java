package leave.controller;

import leave.service.LeaveInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/leave/delete")
public class LeaveDeleteController extends HttpServlet {
    private LeaveInfoService LIService = new LeaveInfoService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int res = LIService.deleteLeaveInfo(id);
        System.out.println("删除："+res);
        resp.sendRedirect(req.getContextPath()+"/leave/show");
    }
}
