package controller;

import com.google.gson.Gson;
import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.ConstUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/admin")
public class AdminController extends BaseServlet{
    private UserService userService = new UserServiceImpl();

    public String login(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User admin = userService.login(username, password);

        if (admin == null) {
            request.setAttribute("msg", "用户名或密码错误，登录失败");
            return ConstUtils.FORWARD + "/admin/login.jsp";
        } else {
            if (admin.getU_role() == 1) {
                request.getSession().setAttribute("username",username);
                request.setAttribute("admin",admin);
                return ConstUtils.FORWARD + "/admin/admin.jsp";
            } else {
                request.setAttribute("msg","管理员才能登录");
                return ConstUtils.FORWARD + "/admin/login.jsp";
            }
        }
    }

    public String show(HttpServletRequest request, HttpServletResponse response) {
        List<User> vip = userService.showVIP();
        return new Gson().toJson(vip);//将对象解析成json数据,回传出去
    }

    public String deleteUser(HttpServletRequest request, HttpServletResponse response) {
        String uId = request.getParameter("u_id");
        int res = userService.deleteUser(uId);
        System.out.println("删除会员：" +res);
        return ConstUtils.REDIRECT + "/admin?action=show";
    }


    public String searchUser(HttpServletRequest request, HttpServletResponse response) {
        String uName = request.getParameter("u_name");

        System.out.println("uname = " +uName);
        List<User> list = userService.searchByName(uName);
        System.out.println("user "+ list);
        return new Gson().toJson(list);//将对象解析成json数据,回传出去
    }

}
