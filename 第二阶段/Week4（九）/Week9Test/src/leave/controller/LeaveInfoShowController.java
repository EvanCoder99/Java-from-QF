package leave.controller;

import leave.dao.LeaveInfoDao;
import leave.dao.impl.LeaveInforDaoImpl;
import leave.entity.LeaveInfo;
import leave.service.LeaveInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/leave/show")
public class LeaveInfoShowController extends HttpServlet {
    private LeaveInfoService infoService = new LeaveInfoService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LeaveInfo> list = infoService.showLeaveInfo(); //请假表信息存入list
//        System.out.println("leaveInfo"+list);
        req.setAttribute("leaveInfo",list);

        req.getRequestDispatcher("/show.jsp").forward(req,resp);

    }
}
