package controller;

import entity.Page;
import entity.Product;
import service.GoodsService;
import service.impl.GoodsServiceImpl;
import utils.ConstUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/goods")
public class ProductController extends BaseServlet {
    private GoodsService goodsService = new GoodsServiceImpl();

    //展示所有商品信息
    public String show(HttpServletRequest request, HttpServletResponse response) {
        //获取tid参数
        int tid = Integer.parseInt(request.getParameter("tid"));    //获取header.jsp
        String current = request.getParameter("currentPage");

        //调用业务层，返回集合
//        List<Product> list = goodsService.showByTid(tid);
//        request.setAttribute("glist",list); //goodsList.jsp获取

        Page<Product> page = goodsService.getPage(tid, current);
        System.out.println(page);

        //存储分页信息
        request.setAttribute("p",page); //goodsList.jsp获取值

        //展示完成，进行转发
        return ConstUtils.FORWARD+"/goodsList.jsp";
    }

    //展示单个商品信息
    public String goodsDetail(HttpServletRequest request, HttpServletResponse response) {
        int pid = Integer.parseInt(request.getParameter("pid"));
        Product product = goodsService.showByPid(pid);
        request.setAttribute("goods",product);
        return ConstUtils.FORWARD + "/goodsDetail.jsp";
    }

    public void search(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("产品搜索");
    }
}
