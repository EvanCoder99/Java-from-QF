package controller;

import com.google.gson.Gson;
import entity.Type;
import service.TypeService;
import service.impl.TypeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/type")
public class TypeController extends BaseServlet{
    private TypeService typeService = new TypeServiceImpl();

    public String show(HttpServletRequest request, HttpServletResponse response) {
        List<Type> list = typeService.showAll();    //查询类别

        //将对象解析成json数据
        String json = new Gson().toJson(list);
        return json;
    }
}
