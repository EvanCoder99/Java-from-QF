package b_Validate;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/valid")
public class ValidateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //展示验证码
        //参数1，2：宽高  参数3：验证码个数  参数4：干扰线数量
        ValidateCode code = new ValidateCode(150, 50, 4, 10);
        System.out.println("验证码："+code.getCode());
        //存储验证码
        req.getSession().setAttribute("imgCode",code.getCode());
        //写出验证码，传入字节流
        code.write(resp.getOutputStream());
    }
}
