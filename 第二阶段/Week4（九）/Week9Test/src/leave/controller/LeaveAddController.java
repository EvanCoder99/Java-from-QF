package leave.controller;

import leave.entity.LeaveInfo;
import leave.service.LeaveInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/leave/add")
public class LeaveAddController extends HttpServlet {
    private LeaveInfoService LIService = new LeaveInfoService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端的值
        int id = Integer.parseInt(req.getParameter("id"));
        String userId = req.getParameter("user_id");
        String startTime = req.getParameter("starttime");
        String endTime = req.getParameter("endtime");
        String content = req.getParameter("content");
        String name = req.getParameter("name");
        long status = Long.parseLong(req.getParameter("status"));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date starttime = null;
        Date endtime = null;
        try {
            starttime = format.parse(startTime);
            endtime = format.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(starttime + "---" + endtime);
        LeaveInfo leaveInfo = new LeaveInfo(id,userId,content,starttime,endtime,status,name);//存储添加的请假员工信息
        LIService.addLeaveInfo(leaveInfo); //把新增的请假信息存入数据库
        resp.sendRedirect(req.getContextPath()+"/leave/show");
    }

}
