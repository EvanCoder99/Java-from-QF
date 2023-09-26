package controller;

import cn.dsna.util.images.ValidateCode;
import entity.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user")   //http://localhost:8080/user?action=login
public class UserController extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    //模块功能中统一返回字符串，交由BaseServlet统一处理
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(username, password);

        if (user == null) {
            request.setAttribute("msg", "用户名或密码错误，登陆失败");    //login.jsp取值
            return ConstUtils.FORWARD + "/login.jsp";  //重定向到登录页面
        } else {
            if (user.getU_status() == 1) {
                request.getSession().setAttribute(ConstUtils.LOGIN, user);//设置登录凭证，header.jsp获取凭证

                //记录登录账户
                String auto = request.getParameter("auto");//login.jsp自动登录复选框
                Cookie cookie = new Cookie("upass",username+"-"+password);//这里从前端直接获取的是原生的密码，不需要加密，加密是在业务层
                if (auto != null) { //不为Null说明勾选复选框
                    cookie.setMaxAge(60*60*24*14);
                } else {
                    cookie.setMaxAge(0);
                }
                response.addCookie(cookie);

                return ConstUtils.FORWARD + "/index.jsp";
            } else {
                request.setAttribute("msg","用户未激活");
                return ConstUtils.FORWARD +"/login.jsp";  //重定向到登录页面
            }
        }
    }

    //验证码展示
    public void valid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ValidateCode code = new ValidateCode(100, 30, 4, 8);

        //存储验证码
        request.getSession().setAttribute("imgCode",code.getCode());
        code.write(response.getOutputStream()); //写出验证码，传入字节流
    }

    //验证码校对
    public String checkCode(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code"); //从login.jsp的验证码校验获取
        String imgCode = (String) request.getSession().getAttribute("imgCode");
        System.out.println(code +"--"+imgCode);
        if (imgCode.equalsIgnoreCase(code)) {
            return "0"; // 0表示验证成功
        }else
            return "1"; // 1表示验证失败
    }

    public String register(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        //{u_name:zs,u_password:123...}
        Map<String, String[]> map = request.getParameterMap();//获取前端参数的集合
        User user = new User();
        BeanUtils.populate(user,map);  //确保map的属性名和实体的属性名一致

        user.setU_code(RandomUtils.createActive());//创建激活码
        user.setU_role(0);  // 0-会员，1-管理员
        user.setU_status(0);    //激活状态 0-未激活 1-已激活
        user.setU_password(MD5Utils.md5(user.getU_password()));
        int res = userService.register(user);
//        System.out.println("注册："+res);

        if (res == 1) {
            EmailUtils.sendEmail(user); //注册成功，发送邮件
        }

        return ConstUtils.REDIRECT + "/registerSuccess.jsp";
    }

    //用户名校验
    public String check(HttpServletRequest request, HttpServletResponse response) {
        //获取参数，交给业务层处理
        String username = request.getParameter("uername");//获取register.jsp的参数
        System.out.println("用户名："+username);
        User user = userService.checkUser(username);
        if (user == null) {
            return "0"; // 0表示恭喜可用
        }else {
            return "1"; // 1表示已注册
        }
    }

    //激活邮箱
    public String active(HttpServletRequest request, HttpServletResponse response) {
        String c = request.getParameter("c");   //获取激活码
        String code = Base64Utils.decode(c);    //解码
        User user = userService.selectByCode(code);//根据激活码返回对象
        if (user == null) {
            request.setAttribute("msg","激活失败"); //message.jsp获取值
            return ConstUtils.FORWARD+"/message.jsp";
        }else{
            if (user.getU_status() == 1) {
                request.setAttribute("msg","请不要重复激活");
            }else {
                int res = userService.updateStatus(user.getU_id());
                System.out.println("修改激活状态："+res);
                request.setAttribute("msg","激活成功");
            }
        }
        return ConstUtils.FORWARD+"/message.jsp";
    }

    //注销
    public String logOut(HttpServletRequest request, HttpServletResponse response) {
        //移除session
        request.getSession().removeAttribute(ConstUtils.LOGIN);

        //清除cookie
        //只需要匹配key就行，value可以任意写
        Cookie cookie = new Cookie("upass", "xxx");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return ConstUtils.REDIRECT+"/index.jsp";
    }
}
