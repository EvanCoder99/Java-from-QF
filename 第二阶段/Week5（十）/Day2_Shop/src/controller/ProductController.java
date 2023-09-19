package controller;

import utils.ConstUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class ProductController extends BaseServlet {
    public String show(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("产品展示");
//        request.getRequestDispatcher("/show.jsp").forward(request,response);
        return ConstUtils.FORWARD+"/show.jsp";
    }

    public void search(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("产品搜索");
    }
}
