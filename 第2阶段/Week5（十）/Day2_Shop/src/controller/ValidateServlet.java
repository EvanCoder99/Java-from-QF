package controller;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/code")
public class ValidateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValidateCode code = new ValidateCode(100, 30, 4, 8);

        //存储验证码
        req.getSession().setAttribute("imgCode",code.getCode());
        code.write(resp.getOutputStream()); //写出验证码，传入字节流
    }
}
